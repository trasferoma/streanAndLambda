package it.studio_java8.victor_rentea.suddivisione_stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Stream;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Order;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.OrderLine;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Product;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.repository.ProductRepository;

public class MegaPipelineRifattorizzata {

    private ProductRepository productRepo = new ProductRepository();

    public List<Product> getFrequentOrderProducts(List<Order> orders) {

        List<Long> hiddenProductIds = productRepo.getHiddenProductIds();

        Predicate<Product> productIsNotHidden = p -> !hiddenProductIds.contains(p.getId());

        Stream<Product> frequentProducts = productsCountOverPreviusYear(orders).entrySet()
                .stream()
                .filter(e -> e.getValue() > 10)
                .map(Entry::getKey);

        return frequentProducts
                .filter(Product::isNotDeleted)
                .filter(productIsNotHidden)
                .collect(toList());
    }

    private Map<Product, Integer> productsCountOverPreviusYear(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getCreationDate().isAfter(LocalDate.now().minusYears(1)))
                .flatMap(o -> o.getOrderLines().stream())
                .collect(groupingBy(OrderLine::getProduct, summingInt(OrderLine::getItemCount)));
    }

    public static void main(String[] args) {
        MegaPipelineRifattorizzata megaPipeline = new MegaPipelineRifattorizzata();

        List<Order> dati = CreaDati.crea();

        List<Product> elenco = megaPipeline.getFrequentOrderProducts(dati);

        System.out.println(elenco);
    }

}
