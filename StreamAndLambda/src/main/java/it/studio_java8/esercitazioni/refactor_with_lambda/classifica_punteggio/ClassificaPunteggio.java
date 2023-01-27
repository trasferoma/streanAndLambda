package it.studio_java8.esercitazioni.refactor_with_lambda.classifica_punteggio;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassificaPunteggio {
    public static void main(String[] args) {
        Map<String, Integer> punteggi = new HashMap<>();

        punteggi.put("Jack", 12);
        punteggi.put("Jill", 15);
        punteggi.put("Tom", 11);
        punteggi.put("Darla", 15);
        punteggi.put("Nick", 15);
        punteggi.put("Nancy", 11);

        faiClassifica(punteggi);

        System.out.println(faiClassifica(punteggi));
    }

    private static Map<Integer, List<String>> faiClassifica(Map<String, Integer> punteggi) {
        return punteggi.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .keySet()
                .stream()
                .collect(Collectors.groupingBy(punteggi::get, LinkedHashMap::new, Collectors.toList()));
    }
}
