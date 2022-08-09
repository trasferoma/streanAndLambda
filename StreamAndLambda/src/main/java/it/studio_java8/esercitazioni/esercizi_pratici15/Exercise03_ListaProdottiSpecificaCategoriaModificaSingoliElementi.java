package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount

public class Exercise03_ListaProdottiSpecificaCategoriaModificaSingoliElementi {
    private ProductBuilder productBuilder = new ProductBuilder();

    @Getter
    private List<Product> prodotti = new ArrayList<>();

    public Exercise03_ListaProdottiSpecificaCategoriaModificaSingoliElementi() {
        caricaListaProdotti();
    }

    public void caricaListaProdotti() {
        prodotti.add(productBuilder.build(Product.Categories.BOOK, 99));
        prodotti.add(productBuilder.build(Product.Categories.TOYS, 50));
        prodotti.add(productBuilder.build(Product.Categories.BOOK, 200));
        prodotti.add(productBuilder.build(Product.Categories.BABY));
        prodotti.add(productBuilder.build(Product.Categories.TOYS, 100));
    }

    public static void main(String[] args) {
        Exercise03_ListaProdottiSpecificaCategoriaModificaSingoliElementi esercizio = new Exercise03_ListaProdottiSpecificaCategoriaModificaSingoliElementi();

        List<Product> ritorno = esercizio.getProdotti()
                .stream()
                .filter(p -> p.getCategory().equals(Product.Categories.TOYS))
                .map(p -> p.withPrice(calcolaPrezzoScontato(p.getPrice())))
                .collect(Collectors.toList());

        ritorno.stream().forEach(System.out::println);
    }

    // 100 : 10 = prezzo : x
    private static double calcolaPrezzoScontato(double prezzo) {
        double sconto = prezzo * 10 / 100;
        return prezzo - sconto;
    }


}
