package entitiesFunc;

import extras.Beneficio;
import extras.Desconto;
import extras.Departamento;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected Departamento dep;
    protected Beneficio beneficios;
    protected Desconto descontos;

    public Funcionario(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dep = dep;
        this.beneficios = beneficios;
        this.descontos = descontos;
    }

    public double calcularSalario(){
        return salario + beneficios.beneficiosTotais();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void emitirDetalhamento() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.printf("Salário Base: R$%.2f\n", salario);

        if (this instanceof Administrador) {
            System.out.printf("Bonificação da Chefia: R$%.2f\n", ((Administrador) this).getBonusChefia());
        } else if (this instanceof Vendedor) {
            System.out.printf("Adicional de Comissão: R$%.2f\n", ((Vendedor) this).getComissaoAcumulada());
        } else if (this instanceof Entregador) {
            System.out.printf("Adicional de Periculosidade: R$%.2f\n", ((Entregador) this).getPericulosidade());
        }

        System.out.printf("Beneficios: R$%.2f (Plano de Saúde) + R$%.2f (Vale Transporte)\n", beneficios.getAdicionalPlanoSaude(), beneficios.getValeTransporte());

        double descontoINSS = descontos.calcularINSS(calcularSalario());
        double descontoIR = descontos.calcularIR(calcularSalario());

        System.out.printf("Descontos: R$%.2f (INSS) + R$%.2f (Imposto de Renda)\n", descontoINSS, descontoIR);

        double salarioFinal = calcularSalario();
        System.out.printf("Salário Final: R$%.2f\n", salarioFinal);
        System.out.println();
    }
}