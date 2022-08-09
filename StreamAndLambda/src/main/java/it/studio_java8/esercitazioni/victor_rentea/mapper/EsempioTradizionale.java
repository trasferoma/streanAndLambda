package it.studio_java8.esercitazioni.victor_rentea.mapper;

import java.util.ArrayList;
import java.util.List;
import it.studio_java8.esercitazioni.victor_rentea.mapper.pojo.User;
import it.studio_java8.esercitazioni.victor_rentea.mapper.pojo.UserDto;
import it.studio_java8.esercitazioni.victor_rentea.mapper.repository.UserRepository;

public class EsempioTradizionale {

    private UserRepository repository = new UserRepository();

    public List<UserDto> esegui() {
        List<User> elenco = repository.findAll();

        List<UserDto> ritorno = new ArrayList<>();

        for (User user : elenco) {
            UserDto userDto = new UserDto();

            userDto.setNome(user.getNome());
            userDto.setCognome(user.getCognome());

            ritorno.add(userDto);
        }

        return ritorno;
    }

    public static void main(String[] args) {
        EsempioTradizionale esempio = new EsempioTradizionale();
        List<UserDto> elencoDto = esempio.esegui();

        System.out.println(elencoDto);
    }

}
