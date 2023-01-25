package it.studio_java8.victor_rentea.suddivisione_stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Map<String, String> mappa = new HashMap<>();
        mappa.put("nome", "Fabio");
        mappa.put("cognome", "De Arcangelis");

        System.out.println(mappa);

        Set<Entry<String, String>> entrySet = mappa.entrySet();

        System.out.println(entrySet);
    }
}
