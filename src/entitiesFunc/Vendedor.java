package entitiesFunc;

import extras.Beneficio;
import extras.Desconto;
import extras.Venda;
import extras.Departamento;
import java.util.ArrayList;

public class Vendedor extends Funcionario{
    private double comissao;
    private double comissaoAcumulada;
    private ArrayList<Venda> vendas;

    public Vendedor(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos, double comissao){
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.comissao = comissao;
        comissaoAcumulada = 0.0;
        vendas = new ArrayList<>();
    }

    public void setComissao(double comissao){
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void registrarVenda(String data, double valor, boolean status) {
        Venda venda = new Venda(data, valor, status);
        vendas.add(venda);
        comissaoAcumulada += comissao * venda.getValor();
    }

    public double getComissaoAcumulada() {
        return comissaoAcumulada;
    }

    public double ajustarComissao(double novaComissao) {
        double totalNovaComissao = 0.0;
        for (Venda venda : vendas) {
            if (venda.getStatus()) {
                totalNovaComissao += novaComissao * venda.getValor();
            }
        }
        return totalNovaComissao;
    }

    @Override
    public double calcularSalario() {
        double totalComissao = 0.0;
        for (Venda venda : vendas) {
            if (venda.getStatus()) {
                totalComissao += comissao * venda.getValor();
            }
        }
        double salarioTotal = super.calcularSalario() + totalComissao;
        return salarioTotal - descontos.calcularDescontos(salarioTotal);
    }

}