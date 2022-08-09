package it.studio_java8.esercitazioni.esercizi_libro_java8;

import java.util.Arrays;
import java.util.List;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Trader;
import it.studio_java8.esercitazioni.esercizi_libro_java8.pojo.Transaction;
import lombok.Getter;

// Valore più alto

public class ValorePiuAlto {

    @Getter
    private List<Transaction> transazioni = null;

    public ValorePiuAlto() {
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
        ValorePiuAlto esercizio = new ValorePiuAlto();

        SoluzioneA(esercizio);

        SoluzioneB(esercizio);
    }

    private static void SoluzioneA(ValorePiuAlto esercizio) {
        Integer valore = esercizio.getTransazioni()
                .stream()
                .map(e -> e.getValue())
                .reduce(Integer::max)
                .orElse(0);

        System.out.println(valore);
    }

    private static void SoluzioneB(ValorePiuAlto esercizio) {
        Integer valore = esercizio.getTransazioni()
                .stream()
                .mapToInt(e -> e.getValue())
                .max()
                .orElse(0);

        System.out.println(valore);
    }
}
