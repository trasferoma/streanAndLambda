package it.studio_java8.esercitazioni.esercizio_popola_lista;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class PopolaElencoElemento<T, E> {
    public List<T> esegui(List<E> sorgente) {

        return sorgente.stream()
                .filter(getPredicato())
                .map(e -> trasformaSingoloElemento(e))
                .collect(Collectors.toList());
    }

    protected abstract Predicate<? super E> getPredicato();

    protected abstract T trasformaSingoloElemento(E e);
}
