package it.studio_java8.esercitazioni.esempio_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Esempio {

    public static void faiCalcolo(Function<Integer, Integer> operazione) {
        List<Integer> sorgente = Arrays.asList(1, 2, 3, 4, 5);

        sorgente.stream()
                // .map(n -> n * 2)
                .map(operazione)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        Function<Integer, Integer> raddoppia = n -> n * 2;
        Function<Integer, Integer> aggiungi = n -> n + 1;

        Esempio.faiCalcolo(aggiungi.andThen(raddoppia));

        // Esempio.faiCalcolo(n -> n * 2);
        // Esempio.faiCalcolo(n -> n + 1);


    }
}
