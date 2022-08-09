package it.studio_java8.esercitazioni.refactor_with_lambda.raggruppamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prima {
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
        Map<Integer, List<String>> perPunteggio = new HashMap<>();

        for (String nome : punteggi.keySet()) {
            Integer punteggio = punteggi.get(nome);

            List<String> nomi;

            if (perPunteggio.containsKey(punteggio)) {
                nomi = perPunteggio.get(punteggio);
            } else {
                nomi = new ArrayList<>();
                perPunteggio.put(punteggio, nomi);
            }

            nomi.add(nome);

        }
        return perPunteggio;
    }
}
