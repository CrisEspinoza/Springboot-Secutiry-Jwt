package Autentificacion.Microservicio.de.autentificacion.configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class jwtUtil {

    static void addAuthentication(HttpServletResponse res, String name) {
        String token = Jwts.builder()
                .setSubject(name)
                .signWith(SignatureAlgorithm.HS512, "HU@SO")
                .compact();

        res.addHeader("Authorization", "Bearer" + token);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null)
        {
            String user = Jwts.parser()
                    .setSigningKey("HU@SO")
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
                    null;
        }
        return null;
    }
}
