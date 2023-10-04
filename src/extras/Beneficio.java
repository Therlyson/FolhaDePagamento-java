package extras;

public class Beneficio{
    private double adicionalPlanoSaude;
    private double valeTransporte;

    public Beneficio(double adicionalPlanoSaude, double valeTransporte) {
        this.adicionalPlanoSaude = adicionalPlanoSaude;
        this.valeTransporte = valeTransporte;
    }

    public double beneficiosTotais(){
        return adicionalPlanoSaude + valeTransporte;
    }

    public void setAdicionalPlanoSaude(double adicionalPlanoSaude) {
        this.adicionalPlanoSaude = adicionalPlanoSaude;
    }

    public void setValeTransporte(double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public double getAdicionalPlanoSaude() {
        return adicionalPlanoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }
}
