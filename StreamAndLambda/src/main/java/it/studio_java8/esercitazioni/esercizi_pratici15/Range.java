package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// ordinamento inverso
public class Range {
    public static void main(String[] args) {
        int start = 10;
        int end = 20;

        List<Integer> risultato = new ArrayList<>();
        IntStream
                .rangeClosed(start, end)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(e -> risultato.add(e));

        risultato.forEach(System.out::println);
    }
}
