package com.example.fitness.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {
    private final SecretKey key;
    private final long expirationDays;

    public JwtService(@Value("${app.jwt.secret}") String secret,
                      @Value("${app.jwt.expiration-days}") long expirationDays) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationDays = expirationDays;
    }

    public String generateToken(UUID userId, String role) {
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(expirationDays * 24 * 3600);

        return Jwts.builder()
                .subject(userId.toString())
                .claim("role", role)
                .issuedAt(Date.from(now))
                .expiration(Date.from(exp))
                .signWith(key)
                .compact();
    }
}
