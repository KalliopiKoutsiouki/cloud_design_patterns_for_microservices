package com.cloud_dp.pictures_microservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class ServiceAuthenticationProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        // Encode the secret key to avoid having it in plain text
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public Authentication validateToken(String token) {
        System.out.println(token);
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .withSubject("user-pictures-service")
                .withClaim("service", "user-pictures")
                .build();

        DecodedJWT decoded = verifier.verify(token);

        if (!"user-pictures".equals(decoded.getClaim("service").asString())) {
            throw new SecurityException("Unauthorized source");
        }
        return new UsernamePasswordAuthenticationToken(decoded.getSubject(), null, Collections.emptyList());
    }
}
