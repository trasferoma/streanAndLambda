package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.groupingBy;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class MappaDiPersonByName {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        Map<String, List<Person>> elenco = people.stream()
                .collect(groupingBy(Person::getName));


        System.out.println(elenco);

    }
}
