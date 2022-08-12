package it.studio_java8.esercitazioni.collectors;

import static java.util.stream.Collectors.partitioningBy;
import java.util.List;
import java.util.Map;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class EtaPariEtaDispari {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        Map<Boolean, List<Person>> elenco = people.stream()
                .collect(partitioningBy(person -> person.getAge() % 2 == 0));


        System.out.println(elenco);

    }
}
