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

// Exercise 8 — Calculate total lump sum of all orders placed greather or equals today

public class Exercise08_SommaImportiProdotti {
    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise08_SommaImportiProdotti() {
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
        Exercise08_SommaImportiProdotti esercizio = new Exercise08_SommaImportiProdotti();

        List<Order> ordini = esercizio.getOrdini();

        Number sommaDegliImportiDeiProdotti1 = ordini.stream()
                .filter(e -> e.getOrderDate().compareTo(LocalDate.now()) >= 0)
                .peek(System.out::println)
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.reducing(0, Product::getPrice, (x, y) -> x.doubleValue() + y.doubleValue()));

        System.out.println("importiMoltiplicati: " + sommaDegliImportiDeiProdotti1);

        Number sommaDegliImportiDeiProdotti2 = ordini.stream()
                .filter(e -> e.getOrderDate().compareTo(LocalDate.now()) >= 0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();

        System.out.println("importiMoltiplicati: " + sommaDegliImportiDeiProdotti2);
    }
}
