package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 11 — Obtain a data map with order id and order’s product count

public class Exercise11_MappaDiOrdiniPerIdPiuCount {

    private OrderBuilder orderBuilder = new OrderBuilder();
    private ProductBuilder productBuilder = new ProductBuilder();

    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise11_MappaDiOrdiniPerIdPiuCount() {
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
        Exercise11_MappaDiOrdiniPerIdPiuCount esercizio = new Exercise11_MappaDiOrdiniPerIdPiuCount();

        List<Order> ordini = esercizio.getOrdini();

        Map<Long, Integer> ritorno = ordini.stream()
                .collect(
                        Collectors.toMap(
                                order -> order.getId(),
                                order -> order.getProducts().size()));

        ritorno.entrySet().stream().forEach(System.out::println);
    }
}
