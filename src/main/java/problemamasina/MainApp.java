package problemamasina;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class MainApp {
    public static void scriere(List<Autoturism> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("C:\\lucru_java\\problema_masina\\src\\main\\resources\\masini.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Autoturism> citire() {
        try {
            File file = new File("C:\\lucru_java\\problema_masina\\src\\main\\resources\\masini.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Autoturism> autoturisme = mapper.readValue(file, new TypeReference<List<Autoturism>>() {});
            return autoturisme;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {

       List<Autoturism>autoturisme=new ArrayList<>();
//        autoturisms.add(new Masina("Opel",Combustibil.benzina,39000,"Astra"));
//        autoturisms.add(new Motocicleta("Ducatti",Combustibil.motorina,LocalDate.of(2002,11,23)));
//        scriere(autoturisms);

        try {
            File file = new File("C:\\lucru_java\\problema_masina\\src\\main\\resources\\autoturisme.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(";");



                String tipAutoturism = tokens[0];
                String firma = tokens[1];
                Combustibil combustibil = Combustibil.valueOf(tokens[2].trim());

                if (tipAutoturism.equals("Masina")) {

                    double pret = Double.parseDouble(tokens[3]);
                    String model = tokens[4];
                  autoturisme.add(new Masina(firma, combustibil, pret, model));
                    //System.out.println("Mașină: " + autoturisme.toString());
                } else if (tipAutoturism.equals("Motocicleta")) {

                    LocalDate dataFabricatiei = LocalDate.parse(tokens[3]);
                autoturisme.add(new Motocicleta(firma, combustibil, dataFabricatiei));
                    System.out.println("Motocicletă: " + autoturisme.toString());
                } else {
                    System.out.println("Tip de autoturism necunoscut: " + tipAutoturism);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int optiune;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Optiunea:");
            System.out.println("1. Afisare");
            System.out.println("2. Adaugare");
            System.out.println("3. Modificare");
            System.out.println("4. Stergere");
            System.out.println("5. Iesire");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 1:

                    autoturisme.forEach(System.out::println);
                    break;
                case 2:
                    // Add code to add a new Autoturism

                    boolean corect=true;
                   do {
                        System.out.println("Introduceti firma");
                        String firmaCitita=scanner.next();
                        if(!firmaCitita.matches("[a-zA-Z]+$"))
                        {System.out.println("Firma introdusă conține cifre sau caractere speciale. Reîncercați.");
                            corect=false;
                        }
                        if(autoturisme.get(0).getFirma().equalsIgnoreCase(firmaCitita)){
                            System.out.println("firma e aceeasi");
                        }
                        else{
                            System.out.println("firma  nu e aceeasi" );
                        }
                    }while(corect==false);

                    break;
                case 3:

                    System.out.println("Combustibil:");
                   String combustibilCitit=scanner.next().toLowerCase();
                   autoturisme.stream().filter(autoturism -> (autoturism.getCombustibil().name().equalsIgnoreCase(combustibilCitit))).forEach(System.out::println);

                    break;
                case 4:
                    // Add code to delete an Autoturism



                    break;
                case 5:
                    //autoturisme.stream().min(Comparator.comparing(Motocicleta::getDataFabricatiei)).ifPresentOrElse(autoturism -> System.out.println(autoturism.toString()),()-> System.out.println("nu exista"));

                    break;
                default:
                    System.out.println("Optiune invalida.");
                    break;
            }
        } while (optiune != 6);
    }
}
