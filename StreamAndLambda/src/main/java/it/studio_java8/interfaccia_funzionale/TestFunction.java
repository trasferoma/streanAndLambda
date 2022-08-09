package it.studio_java8.interfaccia_funzionale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        List<Elemento> sorgente = Arrays.asList(new Elemento("Fabio", 2), new Elemento("Jester", 21));

        List<Integer> lista = getLista(sorgente, (Elemento e) -> e.eta);

        lista.stream().forEach(System.out::println);
    }

    public static <T, R> List<R> getLista(List<T> lista, Function<T, R> p) {
        List<R> ritorno = new ArrayList<R>();

        for (T t : lista) {
            ritorno.add(p.apply(t));
        }

        return ritorno;
    }

    public static class Elemento {
        public String nome;
        public Integer eta;

        public Elemento(String nome, Integer eta) {
            super();
            this.nome = nome;
            this.eta = eta;
        }
    }
}
