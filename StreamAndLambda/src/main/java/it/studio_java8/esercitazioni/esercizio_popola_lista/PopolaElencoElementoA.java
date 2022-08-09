package it.studio_java8.esercitazioni.esercizio_popola_lista;

import java.util.function.Predicate;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.ElementoA;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.RisultatoElementoA;

public class PopolaElencoElementoA extends PopolaElencoElemento<RisultatoElementoA, ElementoA> {

    @Override
    protected RisultatoElementoA trasformaSingoloElemento(ElementoA e) {
        return RisultatoElementoA.builder()
                .valore1(e.getNome())
                .valore2(e.getCognome())
                .build();
    }

    @Override
    protected Predicate<ElementoA> getPredicato() {
        return e -> e.getNome().equals("Fabio");
    }
}
