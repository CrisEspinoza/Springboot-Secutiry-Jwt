package Autentificacion.Microservicio.de.autentificacion.controller;

import Autentificacion.Microservicio.de.autentificacion.dto.userDto;
import Autentificacion.Microservicio.de.autentificacion.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@Slf4j
@RequestMapping(value = "user")
public class userController {

    private final userService userService;

    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public userDto getByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<userDto> getAllPlayer() {
        return userService.getAllUser();
    }
}
