package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class ContaPersoneStessoNome {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        // la versione semplice calcola i dati in un long
        Map<String, Long> elencoLong = people.stream()
                .collect(
                        groupingBy(Person::getName, counting()));

        System.out.println(elencoLong);

        // Specifichiamo noi il formato, esempio Integer
        Map<String, Integer> elencoInt = people.stream()
                .collect(
                        groupingBy(Person::getName,
                                collectingAndThen(counting(), valore -> valore.intValue())));

        System.out.println(elencoInt);

    }
}
