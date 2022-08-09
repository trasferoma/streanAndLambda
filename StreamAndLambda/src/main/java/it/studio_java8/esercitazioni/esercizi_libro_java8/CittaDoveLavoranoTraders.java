package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Tutte le città in cui lavorano traders.

public class CittaDoveLavoranoTraders {

    @Getter
    private List<Transaction> transazioni = null;

    public CittaDoveLavoranoTraders() {
        caricaListaTranzazioni();
    }

    public void caricaListaTranzazioni() {
        transazioni = Arrays.asList(
                new Transaction(2011, 10, new Trader("AAAA", "Roma")),
                new Transaction(2012, 1, new Trader("BBBB", "Roma")),
                new Transaction(2013, 2, new Trader("CCC", "Milano")),
                new Transaction(2014, 3, new Trader("DDD", "Bari")),
                new Transaction(2011, 1, new Trader("EEEE", "Milano")));

    }

    public static void main(String[] args) {
        CittaDoveLavoranoTraders esercizio = new CittaDoveLavoranoTraders();

        soluzioneA(esercizio);

        System.out.println();

        soluzioneB(esercizio);
    }

    private static void soluzioneA(CittaDoveLavoranoTraders esercizio) {
        Set<String> elenco = esercizio.getTransazioni()
                .stream()
                .map(e -> e.getTrader().getCity())
                .collect(Collectors.toSet());

        elenco.stream().forEach(System.out::println);
    }

    private static void soluzioneB(CittaDoveLavoranoTraders esercizio) {
        List<String> elenco = esercizio.getTransazioni()
                .stream()
                .map(e -> e.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        elenco.stream().forEach(System.out::println);
    }
}
