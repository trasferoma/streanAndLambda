package it.studio_java8.victor_rentea.mapper;

import java.util.List;
import java.util.stream.Collectors;
import it.studio_java8.esercitazioni.victor_rentea.mapper.pojo.User;
import it.studio_java8.esercitazioni.victor_rentea.mapper.pojo.UserDto;
import it.studio_java8.esercitazioni.victor_rentea.mapper.repository.UserRepository;

public class EsempioLambda {

    private UserRepository repository = new UserRepository();
    private Mapper mapper = new Mapper();

    public List<UserDto> esegui() {
        return repository.findAll()
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    class Mapper {
        public UserDto fromUser(User user) {
            UserDto userDto = new UserDto();

            userDto.setNome(user.getNome());
            userDto.setCognome(user.getCognome());

            return userDto;
        }
    }

    public static void main(String[] args) {
        EsempioLambda esempio = new EsempioLambda();
        List<UserDto> elencoDto = esempio.esegui();

        System.out.println(elencoDto);
    }

}
