package it.studio_java8.esercitazioni.refactor_with_lambda.raggruppamento;

import static java.util.stream.Collectors.groupingBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dopo {
    public static void main(String[] args) {
        Map<String, Integer> punteggi = new HashMap<>();

        punteggi.put("A", 1);
        punteggi.put("B", 2);
        punteggi.put("C", 1);
        punteggi.put("D", 2);
        punteggi.put("E", 1);

        System.out.println(raggruppaPerPunteggio(punteggi));
    }

    private static Map<Integer, List<String>> raggruppaPerPunteggio(Map<String, Integer> punteggi) {
        return punteggi.keySet()
                .stream()
                .collect(groupingBy(punteggi::get));
    }
}
