package it.studio_java8.esercitazioni.refactor_with_lambda.iterazione;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dopo {
    public double esegui(int start, int count) {
        return Stream.iterate(start, e -> e + 1)
                .filter(Dopo::isPrime)
                .mapToDouble(Math::sqrt)
                .limit(count)
                .sum();
    }

    private static boolean isPrime(int numero) {
        if (numero == 1) {
            return true;
        }

        return IntStream.range(2, numero)
                .noneMatch(e -> numero % e == 0);
    }
}
