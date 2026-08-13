package com.badcow.utility;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

@Component
@Data
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	// Generate JWT
	public String generateToken(String email) {

		return Jwts.builder().subject(email).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 86400000))
				.signWith(Keys.hmacShaKeyFor(secret.getBytes()), Jwts.SIG.HS256).compact();
	}

	// Extract email from token
	public String extractEmail(String token) {

		Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseSignedClaims(token)
				.getPayload();

		return claims.getSubject();
	}

	// Validate token
	public boolean validateToken(String token) {

		try {

			Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseSignedClaims(token);

			return true;

		} catch (Exception e) {
			return false;
		}
	}
}