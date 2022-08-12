package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class Filtering {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        Map<Integer, List<String>> collect = people.stream()
                .collect(
                        groupingBy(Person::getAge,
                                mapping(Person::getName,
                                        filtering(name -> name.length() > 5, toList()))));


        System.out.println(collect);

    }
}
