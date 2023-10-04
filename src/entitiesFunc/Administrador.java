package entitiesFunc;

import extras.Beneficio;
import extras.Desconto;
import extras.Departamento;

public class Administrador extends Funcionario{
    private double bonusChefia;

    public Administrador(String nome, String cpf, double salario, Departamento dep, Beneficio beneficios, Desconto descontos, double bonusChefia){
        super(nome, cpf, salario, dep, beneficios, descontos);
        this.bonusChefia = bonusChefia;
        // Inicialize os atributos específicos, se houver
    }

    public double calcularSalario() {
        double salarioTotal = super.calcularSalario() + bonusChefia;
        return salarioTotal - descontos.calcularDescontos(salarioTotal);
    }

    public void setBonusChefia(double bonusChefia) {
        this.bonusChefia = bonusChefia;
    }

    public double getBonusChefia() {
        return bonusChefia;
    }
}
