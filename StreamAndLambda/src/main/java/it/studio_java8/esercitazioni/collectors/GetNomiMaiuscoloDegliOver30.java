package it.studio_java8.esercitazioni.collectors;

import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class GetNomiMaiuscoloDegliOver30 {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        List<String> elenco = people.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());


        System.out.println(elenco);

    }
}
