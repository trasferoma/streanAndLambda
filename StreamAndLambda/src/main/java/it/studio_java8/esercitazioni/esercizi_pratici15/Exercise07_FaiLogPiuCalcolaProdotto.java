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

// Exercise 7 — Get a list of orders which were ordered on today, log the order records to the
// console and then return its product list

public class Exercise07_FaiLogPiuCalcolaProdotto {
    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise07_FaiLogPiuCalcolaProdotto() {
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
        Exercise07_FaiLogPiuCalcolaProdotto esercizio = new Exercise07_FaiLogPiuCalcolaProdotto();

        List<Order> ordini = esercizio.getOrdini();

        Number sommaDegliImportiDeiProdotti = ordini.stream()
                .filter(e -> e.getOrderDate().equals(LocalDate.now()))
                .peek(System.out::println)
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.reducing(0, Product::getPrice, (x, y) -> x.doubleValue() + y.doubleValue()));

        System.out.println("importiMoltiplicati: " + sommaDegliImportiDeiProdotti);


        List<Product> ritorno = ordini.stream()
                .filter(e -> e.getOrderDate().equals(LocalDate.now()))
                .peek(System.out::println)
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.toList());

        ritorno.stream().forEach(System.out::println);
    }
}
