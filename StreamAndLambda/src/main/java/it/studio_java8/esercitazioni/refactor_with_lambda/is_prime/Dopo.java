package it.studio_java8.esercitazioni.refactor_with_lambda.is_prime;

import java.util.stream.IntStream;

public class Dopo {
    public static boolean isPrimo(int numero) {
        return IntStream.range(2, numero)
                .noneMatch(e -> numero % e == 0);
    }

    public static void main(String[] args) {
        IntStream.range(1, 8)
                .forEach(n -> System.out.println(n + ": " + Dopo.isPrimo(n)));
    }
}
