package it.studio_java8.esercitazioni.refactor_with_lambda.iterazione;

import java.util.stream.IntStream;

public class Prima {
    public double esegui(int start, int count) {
        int index = start;
        int computedCount = 0;
        double sum = 0;

        while (computedCount < count) {
            if (isPrime(index)) {
                sum += Math.sqrt(index);
            }
            computedCount++;
        }

        return sum;
    }

    private boolean isPrime(int numero) {
        if (numero == 1) {
            return true;
        }

        return IntStream.range(2, numero)
                .noneMatch(e -> numero % e == 0);
    }
}
