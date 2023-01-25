package it.studio_java8.victor_rentea.suddivisione_stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Order;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.OrderLine;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Product;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.repository.ProductRepository;

public class MegaPipeline {

    private ProductRepository productRepo = new ProductRepository();

    public List<Product> getFrequentOrderProducts(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 10)
                .map(Entry::getKey)
                .filter(p -> !p.isDeleted())
                .filter(p -> !productRepo.getHiddenProductIds().contains(p.getId()))
                .collect(toList());
    }

    public static void main(String[] args) {
        MegaPipeline megaPipeline = new MegaPipeline();

        List<Order> dati = CreaDati.crea();

        List<Product> elenco = megaPipeline.getFrequentOrderProducts(dati);

        System.out.println(elenco);
    }

}
