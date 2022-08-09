package it.studio_java8.interfaccia_funzionale;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        List<String> sorgente = Arrays.asList("fabio", "jester");

        getLista(sorgente, System.out::println);
    }

    public static <T> void getLista(List<T> lista, Consumer<T> p) {
        for (T t : lista) {
            p.accept(t);
        }
    }
}
