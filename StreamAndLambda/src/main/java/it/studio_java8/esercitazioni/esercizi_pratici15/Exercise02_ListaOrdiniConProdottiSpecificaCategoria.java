package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 2 — Obtain a list of order with products belong to category “Baby”

public class Exercise02_ListaOrdiniConProdottiSpecificaCategoria {
    private OrderBuilder orderBuilder = new OrderBuilder();
    private ProductBuilder productBuilder = new ProductBuilder();

    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise02_ListaOrdiniConProdottiSpecificaCategoria() {
        caricaOrdini();
    }

    public void caricaOrdini() {
        ordini.add(orderBuilder.build(Product.Categories.BOOK));
        ordini.add(orderBuilder.build(Product.Categories.BOOK));
        ordini.add(orderBuilder.build(Product.Categories.BOOK));

        Order order = orderBuilder.build(Product.Categories.BABY);
        Product product = productBuilder.build(Product.Categories.BOOK);
        order.add(product);
        ordini.add(order);

        ordini.add(orderBuilder.build(Product.Categories.TOYS));
    }

    public static void main(String[] args) {
        Exercise02_ListaOrdiniConProdottiSpecificaCategoria esercizio = new Exercise02_ListaOrdiniConProdottiSpecificaCategoria();



        List<Product> ritornoProdotti = esercizio.getOrdini()
                .stream()
                .map(Order::getProducts)
                .flatMap(p -> p.stream())
                .filter(p -> p.getCategory().equals(Product.Categories.BABY))
                .collect(Collectors.toList());

        ritornoProdotti.stream().forEach(System.out::println);


        List<Order> ritornoOrder = esercizio.getOrdini()
                .stream()
                .filter(o -> o.getProducts()
                        .stream()
                        .anyMatch(p -> p.getCategory().equals(Product.Categories.BABY)))
                .collect(Collectors.toList());

        ritornoOrder.stream().forEach(System.out::println);

    }


}
