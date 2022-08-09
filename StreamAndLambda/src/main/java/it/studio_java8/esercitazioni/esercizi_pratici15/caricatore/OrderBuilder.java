package it.studio_java8.esercitazioni.esercizi_pratici15.caricatore;

import java.time.LocalDate;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product.Categories;

public class OrderBuilder {
    private long lastId = 0;

    public Order build(Categories category) {

        ProductBuilder productBuilder = new ProductBuilder();

        Product product = productBuilder.build(category);

        Order order = buildOrder();

        order.add(product);

        return order;
    }

    public Order buildOrder() {
        return Order.builder()
                .id(++lastId)
                .deliveryDate(LocalDate.now().plusDays(10))
                .orderDate(LocalDate.now())
                .status(Order.Status.STATE_A)
                .build();
    }
}
