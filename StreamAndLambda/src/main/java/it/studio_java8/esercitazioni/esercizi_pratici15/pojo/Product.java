package it.studio_java8.esercitazioni.esercizi_pratici15.pojo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.With;

@Data
@Builder
public class Product {
    private Long id;

    private String name;
    private Categories category;
    @With
    private double price;

    @ToString.Exclude
    private Set<Order> orders;

    public enum Categories {
        BOOK, BABY, TOYS;
    }

    public void add(Order order) {
        orders = Optional.ofNullable(orders).orElse(new HashSet<Order>());
        orders.add(order);
    }
}
