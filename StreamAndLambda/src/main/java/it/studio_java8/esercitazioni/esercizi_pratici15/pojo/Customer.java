package it.studio_java8.esercitazioni.esercizi_pratici15.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Long id;

    private String name;
    private Integer tier;
}
