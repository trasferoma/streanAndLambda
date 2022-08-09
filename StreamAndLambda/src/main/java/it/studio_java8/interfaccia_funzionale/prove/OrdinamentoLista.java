package it.studio_java8.interfaccia_funzionale.prove;

import java.util.ArrayList;
import java.util.List;

public class OrdinamentoLista {

    public static void main(String[] args) {
        List<Mela> elencoFrutta = caricaElencoFrutta();

        elencoFrutta.sort((Mela m1, Mela m2) -> m1.getPeso().compareTo(m2.getPeso()));


    }

    private static List<Mela> caricaElencoFrutta() {
        List<Mela> elencoFrutta = new ArrayList<>();

        elencoFrutta.add(new Mela(10, "Terza"));
        elencoFrutta.add(new Mela(5, "Prima"));
        elencoFrutta.add(new Mela(7, "Seconda"));

        return elencoFrutta;
    }



}


