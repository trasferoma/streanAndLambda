package it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Order {
    private LocalDate creationDate;
    private List<OrderLine> orderLines;
}
