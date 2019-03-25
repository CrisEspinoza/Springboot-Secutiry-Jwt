package Autentificacion.Microservicio.de.autentificacion.mapper;

import Autentificacion.Microservicio.de.autentificacion.dto.userDto;
import Autentificacion.Microservicio.de.autentificacion.entitie.userEntitie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class userMapper {

    public userDto UserToUserDto (userEntitie user)
    {
        userDto userDto = new userDto();
        userDto.setId_user(user.getId_user());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public List<userDto> generateUserDTOS(List<userEntitie> users)
    {
        int i;
        ArrayList<userDto> usersDto = new  ArrayList<>();
        for (i = 0; i < users.size(); i++ )
        {
            usersDto.add(UserToUserDto(users.get(i)));
        }

        return usersDto;
    }
}
