package com.riwi.beautySalon.infraestructure.helpers;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

// 11
@Component
public class JwtService {
    private final String SECRET_KEY = "bWkgc3VwZXIgY2xhdmUgc2VjcmV0YSBzZWNyZXRhIHNlY3JldGEsIG1pIHN1cGVyIGNsYXZlIHNlY3JldGEgc2VjcmV0YSBzZWNyZXRh";

    // 11.1
    private SecretKey getKey(){
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(KeyBytes);
    } 

    // 11.2

    public String getToken(Map<String, Object> claims, User user){

        return Jwts.builder()
                .claims(claims) // agrego de quien es el Jwt
                .subject(user.getUsername()) // agrego de quien es el jwt
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Fecha de expiracion
                .signWith(this.getKey()) 
                .compact();
    } 

    // 11.3
    public String getToken(User user){
        Map<String,Object> claims = new HashMap<>();

        claims.put("id",user.getId());
        claims.put("rolle", user.getRole().name());

        return getToken(claims, user);

    }

}
