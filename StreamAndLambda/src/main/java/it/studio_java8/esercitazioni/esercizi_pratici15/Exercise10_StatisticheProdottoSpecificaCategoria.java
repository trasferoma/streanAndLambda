package it.studio_java8.esercitazioni.esercizi_pratici15;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import it.studio_java8.esercitazioni.esercizi_pratici15.caricatore.ProductBuilder;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product.Categories;
import lombok.Getter;

// Exercise 9 — Calculate order average payment placed today

public class Exercise10_StatisticheProdottoSpecificaCategoria {
    @Getter
    private List<Product> prodotti = new ArrayList<>();

    public Exercise10_StatisticheProdottoSpecificaCategoria() {

        ProductBuilder productBuilder = new ProductBuilder();

        prodotti.add(productBuilder.build(Categories.BOOK));
        prodotti.add(productBuilder.build(Categories.BOOK));
        prodotti.add(productBuilder.build(Categories.BOOK));
        prodotti.add(productBuilder.build(Categories.BOOK));
        prodotti.add(productBuilder.build(Categories.TOYS));
        prodotti.add(productBuilder.build(Categories.BOOK));
        prodotti.add(productBuilder.build(Categories.BOOK));

    }

    public static void main(String[] args) {
        Exercise10_StatisticheProdottoSpecificaCategoria esercizio = new Exercise10_StatisticheProdottoSpecificaCategoria();

        List<Product> prodotti = esercizio.getProdotti();

        DoubleSummaryStatistics statistics = prodotti.stream()
                .filter(p -> p.getCategory().equals(Product.Categories.BOOK))
                .mapToDouble(p -> p.getPrice())
                .summaryStatistics();

        System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
                statistics.getCount(),
                statistics.getAverage(),
                statistics.getMax(),
                statistics.getMin(),
                statistics.getSum()));

    }
}
