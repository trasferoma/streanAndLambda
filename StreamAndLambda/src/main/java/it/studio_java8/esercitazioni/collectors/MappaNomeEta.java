package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class MappaNomeEta {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        // questo NON funziona se ci sono persone con lo stesso nome.

        // Map<String, Integer> elenco = people.stream()
        // .collect(Collectors.toMap(Person::getName, Person::getAge));
        //
        // System.out.println(elenco);


        Map<String, List<Integer>> elenco = people.stream()
                .collect(groupingBy(
                        Person::getName,
                        mapping(Person::getAge, toList())));

        System.out.println(elenco);

    }
}
