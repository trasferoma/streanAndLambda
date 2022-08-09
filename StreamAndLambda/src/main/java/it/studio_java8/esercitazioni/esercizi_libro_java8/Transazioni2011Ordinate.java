package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// All transaction of 2011 and sort by value

public class Transazioni2011Ordinate {

    @Getter
    private List<Transaction> transazioni = null;

    public Transazioni2011Ordinate() {
        caricaListaTranzazioni();
    }

    public void caricaListaTranzazioni() {
        transazioni = Arrays.asList(
                new Transaction(2011, 10, null),
                new Transaction(2012, 1, null),
                new Transaction(2013, 2, null),
                new Transaction(2014, 3, null),
                new Transaction(2011, 1, null));

    }

    public static void main(String[] args) {
        Transazioni2011Ordinate esercizio = new Transazioni2011Ordinate();
        List<Transaction> elenco = esercizio.getTransazioni()
                .stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        elenco.stream().forEach(System.out::println);
    }


}
