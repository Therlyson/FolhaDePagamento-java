package extras;

public class Desconto {
    private double desInss = 0.11;
    private double desImpostoRenda = 0.15;

    public double calcularINSS(double salario) {
        return salario * desInss;
    }

    public double calcularIR(double salario) {
        return salario * desImpostoRenda;
    }

    public double calcularDescontos(double salario){
        double descontoINSS = calcularINSS(salario);
        double descontoIR = calcularIR(salario);
        return descontoIR + descontoINSS;
    }
}
