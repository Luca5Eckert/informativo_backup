package com.weg.informativos.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Value;

public class JWTUserProvider  {

    private static String secretKey = "chaveSecreta";

    public DecodedJWT validateToken(String token) {
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        try {
            return JWT.require(algorithm).build().verify(token);
        } catch (JWTVerificationException ex) {
            return null;
        }
    }

}
