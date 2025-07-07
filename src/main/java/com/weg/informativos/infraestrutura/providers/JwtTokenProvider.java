package com.weg.informativos.infraestrutura.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {

    @Value("${security.jwt.secret}")
    private String secretKey;

    public String extractUsername(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException ex) {
            return null;
        }
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
            final String usernameFromToken = decodedJWT.getSubject();

            return (usernameFromToken != null && usernameFromToken.equals(userDetails.getUsername()) && !isTokenExpired(decodedJWT));

        } catch (JWTVerificationException ex) {
            return false;
        }
    }

    private boolean isTokenExpired(DecodedJWT token) {
        return token.getExpiresAt().before(new Date());
    }
}