package it.studio_java8.interfaccia_funzionale.prove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreareListConInterfacciaTest {
    public static void main(String[] args) {
        List<String> sorgente = Arrays.asList("Lee", "Jester");

        List<String> sottoLista = creaSottoLista(sorgente);
    }

    public static List<String> creaSottoLista(List<String> input) {
        
        return input
                .stream()
                .filter(s -> s.equals("Jester"))
                .collect(Collectors.toList());
    }
}
