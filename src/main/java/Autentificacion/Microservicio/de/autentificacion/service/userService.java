package Autentificacion.Microservicio.de.autentificacion.service;

import Autentificacion.Microservicio.de.autentificacion.dao.userDao;
import Autentificacion.Microservicio.de.autentificacion.dto.userDto;
import Autentificacion.Microservicio.de.autentificacion.entitie.userEntitie;
import Autentificacion.Microservicio.de.autentificacion.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService implements UserDetailsService {

    private final userDao userDao;
    private final userMapper userMapper;

    @Autowired
    public userService (userDao userDao, userMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public userDto getUserByName (String name)
    {
        userEntitie user = userDao.findByName(name);
        return userMapper.UserToUserDto(user);
    }

    public List<userDto> getAllUser ()
    {
        List<userEntitie> users = userDao.findAll();
        return userMapper.generateUserDTOS(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        userEntitie user = userDao.findByName(username);
        return new User(user.getName(), encoder.encode(user.getPassword()), user.isEstado(), user.isEstado(),
                user.isEstado(), user.isEstado(), buildGrand(user.getRol()));


    }

    public List<GrantedAuthority> buildGrand (byte rol)
    {
        String[] roles = {"1","2","3"};

        List<GrantedAuthority> auths = new ArrayList<>();

        int i;
        for(i = 0 ; i < rol; i++)
            auths.add(new SimpleGrantedAuthority(roles[i]));

        return auths;
    }
}
