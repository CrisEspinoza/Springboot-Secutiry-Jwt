package Autentificacion.Microservicio.de.autentificacion.entitie;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table()
public class userEntitie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_country")
    private Long id_user;

    @Column(name="name",unique=true)
    private String name;

    @Column
    private String password;

    @Column
    private byte rol;

    @Column
    private boolean estado;
}
