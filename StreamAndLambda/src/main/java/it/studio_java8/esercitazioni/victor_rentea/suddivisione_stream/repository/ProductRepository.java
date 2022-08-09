package it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.repository;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    public List<Long> getHiddenProductIds() {
        return Arrays.asList(1L, 2L, 3L);
    }
}
