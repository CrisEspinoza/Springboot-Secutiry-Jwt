package Autentificacion.Microservicio.de.autentificacion.dto;

import lombok.Data;

@Data // Me hace referencia a los getter y a los setter en conjunto
public class userDto {

    private Long id_user;

    private String name;

    private String password;
}
