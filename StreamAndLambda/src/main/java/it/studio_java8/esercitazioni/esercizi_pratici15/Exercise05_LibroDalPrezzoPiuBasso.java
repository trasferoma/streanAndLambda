package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Get the cheapest products of “Books” category

public class Exercise05_LibroDalPrezzoPiuBasso {

    @Getter
    private List<Product> prodotti = new ArrayList<>();

    public Exercise05_LibroDalPrezzoPiuBasso() {
        caricaDatiPerEsercizio();
    }

    public void caricaDatiPerEsercizio() {
        creaProdotti();
    }

    private void creaProdotti() {
        Product elemento;
        ProductBuilder builder = new ProductBuilder();

        elemento = builder.build(Product.Categories.BOOK, 100);
        prodotti.add(elemento);

        elemento = builder.build(Product.Categories.BOOK, 50);
        prodotti.add(elemento);

        elemento = builder.build(Product.Categories.TOYS, 10);
        prodotti.add(elemento);
    }

    public static void main(String[] args) {

        soluzioneA();

        soluzioneB();
    }

    private static void soluzioneB() {
        Exercise05_LibroDalPrezzoPiuBasso esercizio = new Exercise05_LibroDalPrezzoPiuBasso();

        Optional<Product> optProdotto = esercizio.getProdotti()
                .stream()
                .filter(p -> p.getCategory().equals(Product.Categories.BOOK))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();

        if (optProdotto.isPresent()) {
            System.out.println(optProdotto.get());
        } else {
            System.out.println("sconosciuto");
        }
    }

    private static void soluzioneA() {

        Exercise05_LibroDalPrezzoPiuBasso esercizio = new Exercise05_LibroDalPrezzoPiuBasso();

        Optional<Product> optProdotto = esercizio.getProdotti()
                .stream()
                .filter(p -> p.getCategory().equals(Product.Categories.BOOK))
                .collect(Collectors.minBy(Comparator.comparingDouble(Product::getPrice)));

        String nomeProdotto = optProdotto
                .map(p -> p.getName())
                .orElse("sconosciuto");

        System.out.println(nomeProdotto);

        optProdotto.ifPresent(System.out::println);

        if (optProdotto.isPresent()) {
            System.out.println(optProdotto.get());
        } else {
            System.out.println("sconosciuto");
        }
    }


}
