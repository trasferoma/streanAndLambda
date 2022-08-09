package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 11 — Obtain a data map with order id and order’s product count

public class Exercise13_MappaDiOrdiniElementoPiuTotaleProdotti {

    private OrderBuilder orderBuilder = new OrderBuilder();
    private ProductBuilder productBuilder = new ProductBuilder();

    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise13_MappaDiOrdiniElementoPiuTotaleProdotti() {
        caricaOrdini();
    }

    public void caricaOrdini() {
        Order order;

        order = orderBuilder.build(Product.Categories.BOOK);
        ordini.add(order);

        order = orderBuilder.build(Product.Categories.BABY);
        Product product = productBuilder.build(Product.Categories.BOOK);
        order.add(product);
        ordini.add(order);

        order = orderBuilder.build(Product.Categories.BOOK);
        ordini.add(order);

    }

    public static void main(String[] args) {
        Exercise13_MappaDiOrdiniElementoPiuTotaleProdotti esercizio = new Exercise13_MappaDiOrdiniElementoPiuTotaleProdotti();

        List<Order> ordini = esercizio.getOrdini();

        Map<Order, Double> ritorno = ordini.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum()));

        ritorno.entrySet().stream().forEach(System.out::println);

    }
}
