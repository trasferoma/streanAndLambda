package it.studio_java8.interfaccia_funzionale.prove;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EseguiMetodoTest {
    public static void main(String[] args) {
        List<Elemento> sorgente = Arrays.asList(new Elemento("Fabio", 2), new Elemento("Jester", 21));

        processaLaLista(sorgente);
        processaLaLista(sorgente, (e -> e.dump()));
    }

    public static void processaLaLista(List<Elemento> sorgente) {
        sorgente.stream().forEach(e -> e.dump());
        sorgente.stream().forEach(Elemento::dump);
    }

    public static <T> void processaLaLista(List<T> sorgente, Consumer<T> consumer) {
        sorgente.stream().forEach(e -> consumer.accept(e));
    }

    public static class Elemento {
        public String nome;
        public Integer eta;

        public Elemento(String nome, Integer eta) {
            super();
            this.nome = nome;
            this.eta = eta;
        }

        public void dump() {
            String buffer = String.format("Nome: %s, eta: %d", nome, eta);
            System.out.println(buffer);
        }
    }
}
