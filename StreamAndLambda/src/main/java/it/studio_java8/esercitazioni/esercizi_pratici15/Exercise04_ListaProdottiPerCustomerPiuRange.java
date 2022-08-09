package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.OrderBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Customer;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Order;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import lombok.Getter;

// Exercise 4 - Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and
// 01-Apr-2021

public class Exercise04_ListaProdottiPerCustomerPiuRange {

    @Getter
    private List<Order> ordini = new ArrayList<>();

    private Customer customer1;

    private Customer customer2;

    private Customer customer3;

    public Exercise04_ListaProdottiPerCustomerPiuRange() {
        caricaDatiPerEsercizio();
    }

    public void caricaDatiPerEsercizio() {
        creaCustomer();

        creaOrdini();
    }

    private void creaOrdini() {
        Order elemento;
        OrderBuilder builder = new OrderBuilder();

        elemento = builder.build(Product.Categories.TOYS);
        elemento.setOrderDate(LocalDate.parse("2021-01-20", DateTimeFormatter.ISO_DATE));
        elemento.setCustomer(customer2);
        ordini.add(elemento);

        elemento = builder.build(Product.Categories.BOOK);
        elemento.setCustomer(customer3);
        ordini.add(elemento);

        elemento = builder.build(Product.Categories.TOYS);
        elemento.setCustomer(customer1);
        elemento.setOrderDate(LocalDate.parse("2021-02-20", DateTimeFormatter.ISO_DATE));

        ordini.add(elemento);
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

    public static void main(String[] args) {

        LocalDate dataInizio = LocalDate.parse("2021-02-01", DateTimeFormatter.ISO_DATE);
        LocalDate dataFine = LocalDate.parse("2021-04-01", DateTimeFormatter.ISO_DATE);


        dataInizio.compareTo(dataFine);


        Exercise04_ListaProdottiPerCustomerPiuRange esercizio = new Exercise04_ListaProdottiPerCustomerPiuRange();
        List<Product> ritorno = esercizio.getOrdini()
                .stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .sorted(Comparator.comparing(o -> o.getCustomer().getName()))
                .filter(o -> dataInizio.compareTo(o.getOrderDate()) <= 0)
                .filter(o -> dataFine.compareTo(o.getOrderDate()) >= 0)
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.toList());

        ritorno.stream().forEach(System.out::println);
    }


}
