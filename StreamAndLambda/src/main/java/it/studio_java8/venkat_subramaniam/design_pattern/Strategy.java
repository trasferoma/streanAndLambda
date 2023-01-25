package it.studio_java8.venkat_subramaniam.design_pattern;

import java.util.List;
import java.util.function.Predicate;

public class Strategy {

    private static int somma(List<Integer> sorgente, Predicate<Integer> selettore) {
        return sorgente.stream()
                .filter(selettore)
                .mapToInt(e -> e)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> sorgente = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(somma(sorgente, e -> true));
        System.out.println(somma(sorgente, e -> e % 2 == 0));
        System.out.println(somma(sorgente, e -> e % 2 != 0));

    }
}
