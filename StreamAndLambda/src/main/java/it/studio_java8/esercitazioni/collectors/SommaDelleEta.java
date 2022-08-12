package it.studio_java8.esercitazioni.collectors;

import java.util.List;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class SommaDelleEta {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        Integer somma = people.stream()
                .map(Person::getAge)
                .reduce(0, (totale, eta) -> totale + eta);

        System.out.println(somma);

    }
}
