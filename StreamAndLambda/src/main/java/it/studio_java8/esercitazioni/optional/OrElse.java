package it.studio_java8.esercitazioni.optional;

import java.util.Optional;

public class OrElse {
    public void esegui() {

        Optional<String> opt = Optional.of("XXX");

        String buffer = opt
                .map(e -> scriviValore(e))
                .orElseGet(() -> valoreNonPresente());

        System.out.println(buffer);
    }

    private String scriviValore(String st) {
        System.out.println("Valore presente");
        return st;
    }

    private String valoreNonPresente() {
        System.out.println("Valore Non presente");
        return "ZZZ";
    }

    public static void main(String[] args) {
        OrElse handle = new OrElse();

        handle.esegui();
    }
}
