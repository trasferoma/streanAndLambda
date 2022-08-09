package it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @EqualsAndHashCode.Include
    private Long id;
    private boolean deleted;

    public boolean isNotDeleted() {
        return !deleted;
    }
}
