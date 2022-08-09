package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Strina fatta da tutti i nomi dei traders ordinati

public class StringaTuttiNomiTraders {

    @Getter
    private List<Transaction> transazioni = null;

    public StringaTuttiNomiTraders() {
        caricaListaTranzazioni();
    }

    public void caricaListaTranzazioni() {
        transazioni = Arrays.asList(
                new Transaction(2011, 10, new Trader("BBBB", "Roma")),
                new Transaction(2011, 10, new Trader("BBBB", "Milano")),
                new Transaction(2012, 1, new Trader("AAAA", "Roma")),
                new Transaction(2013, 2, new Trader("CCC", "Milano")),
                new Transaction(2014, 3, new Trader("DDD", "Bari")),
                new Transaction(2011, 1, new Trader("EEEE", "Milano")));
    }

    public static void main(String[] args) {
        StringaTuttiNomiTraders esercizio = new StringaTuttiNomiTraders();

        String buffer = esercizio.getTransazioni()
                .stream()
                .map(e -> e.getTrader().getName())
                .distinct()
                .sorted()
                // .reduce("", (n1, n2) -> n1 + n2);
                .collect(Collectors.joining());

        System.out.println(buffer);
    }
}
