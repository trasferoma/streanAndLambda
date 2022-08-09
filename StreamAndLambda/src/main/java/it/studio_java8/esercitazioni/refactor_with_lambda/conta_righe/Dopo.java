package it.studio_java8.esercitazioni.refactor_with_lambda.conta_righe;

import java.util.stream.Stream;

public class Dopo {
    public static void main(String[] args) {
        String[] buffer = new String[] {"riga 1", "riga 2", "elemento 3"};

        long contatore = Stream.of(buffer)
                .filter(e -> e.contains("elemento"))
                .count();

        System.out.println("Torvate " + contatore + " occorrenze");
    }
}
