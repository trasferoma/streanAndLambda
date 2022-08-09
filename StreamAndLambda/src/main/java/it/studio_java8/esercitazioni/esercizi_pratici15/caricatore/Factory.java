package it.studio_java8.esercitazioni.esercizi_pratici15.caricatore;

import java.time.LocalDate;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Customer;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;

public class Factory {
    private Customer customer;
    private Product product;
    private Order order;

    public void build() {
        buildCustomer();
        buildProduct();
        buildOrder();

        buildRelationS();
    }

    private void buildRelationS() {
        order.setCustomer(customer);
        order.add(product);
        product.add(order);
    }

    private void buildOrder() {
        order = Order.builder()
                .id(10L)
                .deliveryDate(LocalDate.now().plusDays(10))
                .orderDate(LocalDate.now())
                .status(Order.Status.STATE_A)
                .build();

    }

    private void buildProduct() {
        product = Product.builder()
                .id(10L)
                .category(Product.Categories.BOOK)
                .name("ProdottoA")
                .price(1000)
                .build();
    }

    private void buildCustomer() {
        customer = Customer.builder()
                .id(10L)
                .name("Jester")
                .tier(10)
                .build();
    }
}
