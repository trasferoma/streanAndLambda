package it.studio_java8.esercitazioni.esercizi_pratici15.caricatore;

import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product;
import it.studio_java8.esercitazioni.esercizi_pratici15.pojo.Product.Categories;
import it.studio_java8.esercitazioni.utils.GeneratoreDouble;
import it.studio_java8.esercitazioni.utils.GeneratoreStringhe;

public class ProductBuilder {
    private long lastId = 0;

    public Product build(Categories category) {
        return Product.builder()
                .id(++lastId)
                .name(GeneratoreStringhe.get())
                .category(category)
                .price(GeneratoreDouble.get())
                .build();
    }

    public Product build(Categories category, double price) {
        Product ritorno = build(category);
        ritorno.setPrice(price);

        return ritorno;
    }
}
