package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class MappaEtaPiuNome {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        Map<Integer, List<String>> collect = people.stream()
                .collect(
                        groupingBy(Person::getAge,
                                mapping(Person::getName, toList())));

        System.out.println(collect);

        // estraggo il nominativo corrispondente alla condizione sull'eta
        List<String> collect2 = people.stream()
                .collect(groupingBy(Person::getAge))
                .entrySet()
                .stream()
                .filter(e -> e.getKey() > 20)
                .filter(e -> e.getKey() < 50)
                .flatMap(e -> e.getValue().stream())
                .map(e -> e.getName())
                .collect(toList());

        System.out.println(collect2);
    }
}
