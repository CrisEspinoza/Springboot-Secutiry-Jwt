package Autentificacion.Microservicio.de.autentificacion.dao;

import Autentificacion.Microservicio.de.autentificacion.entitie.userEntitie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userDao extends JpaRepository<userEntitie,Long> {

    List<userEntitie> findAll();
    userEntitie findByName(String name);
}
