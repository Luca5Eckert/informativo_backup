package com.weg.informativos.infraestrutura.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.weg.informativos.infraestrutura.security.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${security.jwt.secret}")
    private String secretKey;

    @Value("${security.jwt.expiration-ms}")
    private long expirationMs;

    /**
     * Gera um token de jwt com o email do usuário
     * @param email nome do usuario
     * @return token gerado com o nome
     */
    public String generateToken(String email) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Instant now = Instant.now();
        Instant expirationTime = now.plusMillis(expirationMs);

        return JWT.create()
                .withSubject(email)
                .withIssuedAt(now)
                .withExpiresAt(expirationTime)
                .sign(algorithm);
    }

    /**
     * Extrai o email inserido no token
     * @param token recebe o token do usuário
     * @return retorna o email do usuario no token
     */
    public String extractEmail(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getSubject();
        } catch (JWTDecodeException e) {
            // Adicionar tratamento futuramente
            return null;
        }

    }

    /**
     * Valida o token verificando se cumpre com o usuário buscado e se já não expirou
     * @param token       token para validação
     * @param userDetails usuario buscado do banco de dados
     * @return retorna uma booleana verdadeira caso token seja valido
     */
    public boolean validateToken(String token, UserDetailsImpl userDetails) {
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT decodedJWT = JWT.require(algorithm).withSubject(userDetails.getEmail()).build().verify(token);

            return !decodedJWT.getExpiresAt().before(new Date());
        } catch (JWTVerificationException jve) {
            //Adicionar tratamento futuramente
            return false;
        }


    }


}