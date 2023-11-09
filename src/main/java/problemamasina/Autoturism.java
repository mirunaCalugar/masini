package problemamasina;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autoturism {

    @JsonProperty("firma")
    private String firma;
    private Combustibil combustibil;

    public Autoturism(String firma, Combustibil combustibil) {

        this.firma = firma;
        this.combustibil = combustibil;
    }

    public Autoturism() {
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Combustibil getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(Combustibil combustibil) {
        this.combustibil = combustibil;
    }

    @Override
    public String toString() {
        return "Autoturism{" +
                ", firma='" + firma + '\'' +
                ", combustibil=" + combustibil +
                '}';
    }
}
