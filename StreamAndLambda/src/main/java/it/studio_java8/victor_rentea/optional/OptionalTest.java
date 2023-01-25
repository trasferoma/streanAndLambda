package it.studio_java8.victor_rentea.optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Integer dimensione = Optional.of("input")
                .map(e -> e.length())
                .orElse(0);

        System.out.println(dimensione);


        String valore = getValueInteger(5)
                .flatMap(e -> getValueString(e))
                .orElse("");

        System.out.println("====: " + valore);
    }

    private static Optional<Integer> getValueInteger(Integer val) {
        return Optional.of(5);
    }

    private static Optional<String> getValueString(Integer val) {
        return Optional.of("xxxx");
    }

}
