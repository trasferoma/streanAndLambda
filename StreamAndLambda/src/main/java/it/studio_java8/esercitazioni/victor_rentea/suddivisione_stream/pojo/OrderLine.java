package it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class OrderLine {
    private Product product;
    private int itemCount;
}
