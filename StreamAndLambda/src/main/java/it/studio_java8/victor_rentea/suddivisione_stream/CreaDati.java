package it.studio_java8.victor_rentea.suddivisione_stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Order;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.OrderLine;
import it.studio_java8.esercitazioni.victor_rentea.suddivisione_stream.pojo.Product;

public class CreaDati {
    public static List<Order> crea() {

        List<Order> ritorno = new ArrayList<>();

        List<OrderLine> elencoOrdini = Arrays.asList(
                new OrderLine(new Product(1L, false), 5),
                new OrderLine(new Product(2L, false), 3),
                new OrderLine(new Product(3L, false), 10),
                new OrderLine(new Product(4L, false), 50));

        Order o = new Order(LocalDate.now(), elencoOrdini);

        List<OrderLine> elencoOrdini2 = Arrays.asList(
                new OrderLine(new Product(1L, false), 1));

        Order o2 = new Order(LocalDate.now(), elencoOrdini2);

        ritorno.add(o);
        ritorno.add(o2);

        return ritorno;
    }
}
