package problemamasina;

public class Masina extends Autoturism{
    private double pret;
    private String model;

    public Masina(String firma, Combustibil combustibil, double pret, String model) {
        super(firma, combustibil);
        this.pret = pret;
        this.model = model;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return super.toString()+"Masina{" +
                "pret=" + pret +
                ", model='" + model + '\'' +
                '}';
    }
}
