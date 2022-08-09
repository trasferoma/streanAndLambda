package it.studio_java8.esercitazioni.refactor_with_lambda.is_prime;

import java.util.stream.IntStream;

public class Dopo {
    public static boolean isPrimo(int numero) {
        if (numero == 1) {
            return true;
        }

        return IntStream.range(2, numero)
                .noneMatch(e -> numero % e == 0);
    }

    public static void main(String[] args) {
        System.out.println("1: " + Dopo.isPrimo(1));
        System.out.println("2: " + Dopo.isPrimo(2));
        System.out.println("3: " + Dopo.isPrimo(3));
        System.out.println("4: " + Dopo.isPrimo(4));
        System.out.println("5: " + Dopo.isPrimo(5));
        System.out.println("6: " + Dopo.isPrimo(6));
        System.out.println("7: " + Dopo.isPrimo(7));
    }
}
