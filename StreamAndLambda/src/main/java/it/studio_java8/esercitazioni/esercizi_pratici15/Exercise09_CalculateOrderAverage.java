package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product.Categories;
import lombok.Getter;

// Exercise 9 — Calculate order average payment placed today

public class Exercise09_CalculateOrderAverage {
    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise09_CalculateOrderAverage() {
        Order order;

        OrderBuilder orderBuilder = new OrderBuilder();

        order = orderBuilder.build(Categories.BOOK);
        order.setOrderDate(LocalDate.now().plusDays(5));
        ordini.add(order);

        order = orderBuilder.build(Categories.BOOK);
        order.setOrderDate(LocalDate.now());
        ordini.add(order);

        order = orderBuilder.build(Categories.BOOK);
        order.setOrderDate(LocalDate.now().plusDays(2));
        ordini.add(order);

        order = orderBuilder.build(Categories.BOOK);
        order.setOrderDate(LocalDate.now());
        ProductBuilder productBuilder = new ProductBuilder();
        Product product = productBuilder.build(Categories.TOYS);
        order.add(product);
        ordini.add(order);

        order = orderBuilder.build(Categories.BOOK);
        order.setOrderDate(LocalDate.now().plusDays(10));
        ordini.add(order);
    }

    public static void main(String[] args) {
        Exercise09_CalculateOrderAverage esercizio = new Exercise09_CalculateOrderAverage();

        List<Order> ordini = esercizio.getOrdini();

        Double media = ordini.stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.now()))
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.averagingDouble(p -> p.getPrice()));

        System.out.println(media);

        Double media2 = ordini.stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.now()))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .average()
                .getAsDouble();

        System.out.println(media2);
    }
}
