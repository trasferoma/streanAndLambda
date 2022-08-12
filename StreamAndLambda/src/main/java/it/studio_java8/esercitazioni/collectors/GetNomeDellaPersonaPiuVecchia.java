package it.studio_java8.esercitazioni.collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;
import java.util.List;
import java.util.Optional;
import it.studio_java8.esercitazioni.collectors.pojo.Person;
import it.studio_java8.esercitazioni.collectors.strumenti.CaricaDati;

public class GetNomeDellaPersonaPiuVecchia {
    public static void main(String[] args) {
        List<Person> people = CaricaDati.createPeople();

        String nome = people.stream()
                .collect(collectingAndThen(
                        maxBy(comparing(Person::getAge)),
                        optPerson -> optPerson.map(Person::getName).orElse("")));


        System.out.println("=========: " + nome);


        // soluzione con optional
        Optional<String> optNome = people.stream()
                .collect(collectingAndThen(
                        maxBy(comparing(Person::getAge)),
                        optPerson -> optPerson.map((p) -> Optional.ofNullable(p.getName())).orElse(Optional.empty())));

        optNome.ifPresent(System.out::println);
    }
}
