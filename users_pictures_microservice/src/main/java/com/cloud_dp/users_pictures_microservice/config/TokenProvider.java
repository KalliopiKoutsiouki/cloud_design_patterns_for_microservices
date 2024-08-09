package com.cloud_dp.users_pictures_microservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cloud_dp.users_pictures_microservice.dtos.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.Base64;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        // this is to avoid having the raw secret key available in the JVM
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createUserToken(UserDto user, String secretKey) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("firstName", user.getFirstName())
                .withClaim("lastName", user.getLastName())
                .sign(algorithm);
    }

    public String createPicturesToken() {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject("user-pictures-service")
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("service", "user-pictures")
                .sign(algorithm);
    }
}
