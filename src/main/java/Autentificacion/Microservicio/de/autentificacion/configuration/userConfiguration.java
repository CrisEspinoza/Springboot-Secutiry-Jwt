package Autentificacion.Microservicio.de.autentificacion.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userConfiguration {

    String name;
    String password;
    byte rol;
    boolean estado;
}
