package it.studio_java8.esercitazioni.collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;
import java.util.List;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class GetPersonaPiuVecchia {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        people.stream()
                .collect(maxBy(comparing(Person::getAge)))
                .ifPresent(o -> System.out.println(o));

    }
}
