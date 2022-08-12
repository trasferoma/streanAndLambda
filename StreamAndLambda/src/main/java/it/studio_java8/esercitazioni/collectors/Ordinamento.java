package it.studio_java8.esercitazioni.collectors;

import static java.util.Comparator.comparing;
import java.util.List;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class Ordinamento {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        people.stream()
                .sorted(comparing(Person::getAge)
                        .thenComparing(Person::getName))
                .forEach(System.out::println);

    }
}
