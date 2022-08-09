package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Customer;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 11 — Obtain a data map with order id and order’s product count

public class Exercise12_MappaDiOrdiniPerCustomer {

    private OrderBuilder orderBuilder = new OrderBuilder();
    private ProductBuilder productBuilder = new ProductBuilder();
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise12_MappaDiOrdiniPerCustomer() {
        creaCustomer();
        caricaOrdini();
    }

    private void creaCustomer() {
        customer1 = Customer.builder()
                .id(10L)
                .name("Jester")
                .tier(2)
                .build();

        customer2 = Customer.builder()
                .id(20L)
                .name("Tomax")
                .tier(2)
                .build();

        customer3 = Customer.builder()
                .id(30L)
                .name("Xamot")
                .tier(3)
                .build();
    }


    public void caricaOrdini() {
        Order order;

        order = orderBuilder.build(Product.Categories.BOOK);
        order.setCustomer(customer1);
        ordini.add(order);

        order = orderBuilder.build(Product.Categories.BABY);
        Product product = productBuilder.build(Product.Categories.BOOK);
        order.add(product);
        order.setCustomer(customer2);
        ordini.add(order);

        order = orderBuilder.build(Product.Categories.BOOK);
        order.setCustomer(customer3);
        ordini.add(order);

    }

    public static void main(String[] args) {
        Exercise12_MappaDiOrdiniPerCustomer esercizio = new Exercise12_MappaDiOrdiniPerCustomer();

        List<Order> ordini = esercizio.getOrdini();

        Map<Customer, List<Order>> ritorno = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        ritorno.entrySet().stream().forEach(System.out::println);

    }
}
