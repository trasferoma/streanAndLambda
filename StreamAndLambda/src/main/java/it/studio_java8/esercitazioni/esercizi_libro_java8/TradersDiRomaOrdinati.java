package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Tuii i traders di roma ordinati

public class TradersDiRomaOrdinati {

    @Getter
    private List<Transaction> transazioni = null;

    public TradersDiRomaOrdinati() {
        caricaListaTranzazioni();
    }

    public void caricaListaTranzazioni() {
        transazioni = Arrays.asList(
                new Transaction(2011, 10, new Trader("BBBB", "Roma")),
                new Transaction(2012, 1, new Trader("AAAA", "Roma")),
                new Transaction(2013, 2, new Trader("CCC", "Milano")),
                new Transaction(2014, 3, new Trader("DDD", "Bari")),
                new Transaction(2011, 1, new Trader("EEEE", "Milano")));
    }

    public static void main(String[] args) {
        TradersDiRomaOrdinati esercizio = new TradersDiRomaOrdinati();

        List<Transaction> elenco = esercizio.getTransazioni()
                .stream()
                .filter(e -> e.getTrader().getCity().equals("Roma"))
                .sorted(Comparator.comparing(e -> e.getTrader().getName()))
                .collect(Collectors.toList());

        elenco.stream().forEach(System.out::println);
    }
}
