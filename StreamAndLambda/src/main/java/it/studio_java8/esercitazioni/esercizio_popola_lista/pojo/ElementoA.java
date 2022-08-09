package it.studio_java8.esercitazioni.esercizio_popola_lista.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ElementoA {
    private String nome;
    private String cognome;
}
