package Autentificacion.Microservicio.de.autentificacion.configuration;

import Autentificacion.Microservicio.de.autentificacion.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class webSecurity extends WebSecurityConfigurerAdapter {

    private final userService userService;

    @Autowired
    public webSecurity (userService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception
    {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new loginFilter("/login", authenticationManager()) ,
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new jwtFilter() ,
                        UsernamePasswordAuthenticationFilter.class);

    }

}
