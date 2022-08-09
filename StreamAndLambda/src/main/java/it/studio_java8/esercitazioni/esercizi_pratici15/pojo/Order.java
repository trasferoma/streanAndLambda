package it.studio_java8.esercitazioni.esercizi_pratici15.pojo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;

    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Status status;
    private Customer customer;

    private Set<Product> products;

    public enum Status {
        STATE_A, STATE_B;
    }

    public void add(Product product) {
        products = Optional.ofNullable(products).orElse(new HashSet<Product>());
        products.add(product);
    }

}
