package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import lombok.Getter;

// Exercise 6 — Get the 3 most recent placed order
public class Exercise06_ListaUltimiOrdini {

    @Getter
    private List<Order> ordini = new ArrayList<>();

    public Exercise06_ListaUltimiOrdini() {
        Order order;

        OrderBuilder builder = new OrderBuilder();

        order = builder.buildOrder();
        order.setOrderDate(LocalDate.now().plusDays(5));
        ordini.add(order);

        order = builder.buildOrder();
        order.setOrderDate(LocalDate.now());
        ordini.add(order);

        order = builder.buildOrder();
        order.setOrderDate(LocalDate.now().plusDays(2));
        ordini.add(order);

        order = builder.buildOrder();
        order.setOrderDate(LocalDate.now().plusDays(15));
        ordini.add(order);

        order = builder.buildOrder();
        order.setOrderDate(LocalDate.now().plusDays(10));
        ordini.add(order);

    }

    public static void main(String[] args) {
        Exercise06_ListaUltimiOrdini esercizio = new Exercise06_ListaUltimiOrdini();

        List<Order> ordini = esercizio.getOrdini();

        List<Order> ritorno = ordini.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

        ritorno.stream().forEach(System.out::println);
    }
}
