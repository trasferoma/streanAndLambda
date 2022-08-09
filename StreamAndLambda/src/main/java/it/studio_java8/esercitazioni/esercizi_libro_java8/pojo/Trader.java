package it.studio_java8.esercitazioni.esercizi_libro_java8.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class Trader {
    private String name;
    private String city;
}
