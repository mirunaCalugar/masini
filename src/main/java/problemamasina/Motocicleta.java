package problemamasina;

import java.time.LocalDate;

public class Motocicleta extends Autoturism {
    private LocalDate dataFabricatiei;

    public Motocicleta(String firma, Combustibil combustibil, LocalDate dataFabricatiei) {
        super(firma, combustibil);
        this.dataFabricatiei = dataFabricatiei;
    }

    public LocalDate getDataFabricatiei() {
        return dataFabricatiei;
    }

    public void setDataFabricatiei(LocalDate dataFabricatiei) {
        this.dataFabricatiei = dataFabricatiei;
    }
    public  int vechime(){
        return LocalDate.now().getYear()-this.dataFabricatiei.getYear();
    }
    @Override
    public String toString() {
        return super.toString()+ "Motocicleta{" +
                "dataFabricatiei=" + dataFabricatiei +
                '}';
    }
}
