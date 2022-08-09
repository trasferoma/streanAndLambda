package it.studio_java8.esercitazioni.victor_rentea.mapper.repository;

import java.util.Arrays;
import java.util.List;
import it.studio_java8.esercitazioni.victor_rentea.mapper.pojo.User;

public class UserRepository {
    public List<User> findAll() {
        return Arrays.asList(new User("Fabio", "De Arca"), new User("XXXX", "YYYY"));
    }
}
