package it.studio_java8.esercitazioni.esercizio_popola_lista;

import java.util.function.Predicate;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.ElementoB;
import it.studio_java8.esercitazioni.esercizio_popola_lista.pojo.RisultatoElementoB;

public class PopolaElencoElementoB extends PopolaElencoElemento<RisultatoElementoB, ElementoB> {

    @Override
    protected RisultatoElementoB trasformaSingoloElemento(ElementoB e) {
        return RisultatoElementoB.builder()
                .valore1(e.getCodice())
                .valore2(e.getEta())
                .build();
    }

    @Override
    protected Predicate<ElementoB> getPredicato() {
        return e -> e.getCodice().equals(1L);
    }
}
