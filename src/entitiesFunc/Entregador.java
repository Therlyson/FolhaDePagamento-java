package entitiesFunc;

import extras.Beneficio;
import extras.Desconto;
import extras.Departamento;

public class Entregador extends Funcionario{
    private double periculosidade;

    public Entregador(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos, double periculosidade){
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.periculosidade = periculosidade;
    }

    public double calcularSalario() {
        double salarioTotal = super.calcularSalario() + periculosidade;
        return salarioTotal - descontos.calcularDescontos(salarioTotal);
    }

    public void setPericulosidade(double periculosidade) {
        this.periculosidade = periculosidade;
    }

    public double getPericulosidade() {
        return periculosidade;
    }
}
