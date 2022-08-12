package it.studio_java8.esercitazioni.collectors.strumenti;

import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.stream.Stream;
import it.studio_java8.esercitazioni.collectors.pojo.Person;

public class CaricaDati {
    public static List<Person> createPeople() {
        return Stream.of(
                new Person("Fabio", 46),
                new Person("AAAA", 11),
                new Person("BBBB", 5),
                new Person("CCCC", 12),
                new Person("DDDD", 1),
                new Person("eeeeeeeee", 31),
                new Person("eeeeeeeee", 5))
                .collect(toList());
    }
}
