package it.studio_java8.interfaccia_funzionale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        List<String> sorgente = Arrays.asList("fabio", "jester");

        List<String> lista = getLista(sorgente, (String e) -> e.equals("fabio"));

        lista.stream().forEach(System.out::println);
    }

    public static <T> List<T> getLista(List<T> lista, Predicate<T> p) {
        List<T> ritorno = new ArrayList<T>();

        for (T t : lista) {
            if (p.test(t)) {
                ritorno.add(t);
            }
        }

        return ritorno;
    }
}
