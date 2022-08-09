package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 1 - Obtain a list of products belongs to category “Books” with price > 100

public class Exercise01_ListaProdottiSpecificaCategoriaPiuPrezzo {
    private ProductBuilder productBuilder = new ProductBuilder();

    @Getter
    private List<Product> prodotti = new ArrayList<>();

    public Exercise01_ListaProdottiSpecificaCategoriaPiuPrezzo() {
        caricaListaProdotti();
    }

    public void caricaListaProdotti() {
        prodotti.add(productBuilder.build(Product.Categories.BOOK, 99));
        prodotti.add(productBuilder.build(Product.Categories.BOOK, 50));
        prodotti.add(productBuilder.build(Product.Categories.BOOK, 200));
        prodotti.add(productBuilder.build(Product.Categories.BABY));
        prodotti.add(productBuilder.build(Product.Categories.TOYS));
    }

    public static void main(String[] args) {
        Exercise01_ListaProdottiSpecificaCategoriaPiuPrezzo esercizio = new Exercise01_ListaProdottiSpecificaCategoriaPiuPrezzo();
        List<Product> ritorno = esercizio.getProdotti()
                .stream()
                .filter(p -> p.getCategory().equals(Product.Categories.BOOK))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        ritorno.stream().forEach(System.out::println);
    }


}
