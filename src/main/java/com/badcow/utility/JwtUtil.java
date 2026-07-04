package com.badcow.utility;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
@Component
@Data
public class JwtUtil {

	@Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + 86400000))
                .signWith(
                        Keys.hmacShaKeyFor(secret.getBytes()),
                        Jwts.SIG.HS256)
                .compact();
    }
}
