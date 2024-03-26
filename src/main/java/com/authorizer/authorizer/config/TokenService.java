package com.authorizer.authorizer.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.authorizer.authorizer.user.User;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                        .withIssuer("Authorizer")
                        .withSubject(user.getUsername())
                        .withClaim("role", user.getRole().getRole())
                        .withExpiresAt(genExpirationDate())
                        .sign(algorithm);
            return token;
        } catch (JWTCreationException execption) {
            throw new RuntimeException("Error generating token: " + execption);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm).withIssuer("Authorizer").build().verify(token);
            return JWT.decode(token).getSubject();
        } catch (Exception exception) {
            return "";
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
