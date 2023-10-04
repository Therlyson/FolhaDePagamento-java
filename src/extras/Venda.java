package extras;

public class Venda {
    private String data;
    private double valor;
    private boolean status;

    public Venda(String data, double valor, boolean status){
        this.data = data;
        this.valor = valor;
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public boolean getStatus() {
        return status;
    }
}
