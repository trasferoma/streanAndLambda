package it.studio_java8.esercitazioni.esercizio_popola_lista;

import java.util.ArrayList;
import java.util.List;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.ElementoA;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.ElementoB;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.RisultatoElementoA;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.RisultatoElementoB;
import lombok.Getter;

@Getter
public class Popola {

    List<ElementoA> elencoElementiUno = new ArrayList<>();
    List<ElementoB> elencoElementiDue = new ArrayList<>();

    public Popola() {
        init();
    }

    private void init() {
        elencoElementiUno.add(new ElementoA("Fabio", "De Arca"));
        elencoElementiUno.add(new ElementoA("Irene", "Nisio"));

        elencoElementiDue.add(new ElementoB(1L, 2));
        elencoElementiDue.add(new ElementoB(3L, 4));
    }

    public static void main(String[] args) {
        Popola popola = new Popola();

        PopolaElencoElementoA popolaElencoElementoA = new PopolaElencoElementoA();
        List<RisultatoElementoA> elencoRisultatoA = popolaElencoElementoA.esegui(popola.getElencoElementiUno());
        elencoRisultatoA.forEach(System.out::println);

        PopolaElencoElementoB popolaElencoElementoB = new PopolaElencoElementoB();
        List<RisultatoElementoB> elencoRisultatoB = popolaElencoElementoB.esegui(popola.getElencoElementiDue());
        elencoRisultatoB.forEach(System.out::println);
    }
}
