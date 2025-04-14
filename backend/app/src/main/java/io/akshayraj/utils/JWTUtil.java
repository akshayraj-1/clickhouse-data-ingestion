package io.akshayraj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.groovy.util.SystemUtil;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JWTUtil {

    @Value("${jwt.secret}")
    private static String secret;
    private static final SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    private static final long expiration = 1000 * 60 * 60 * 24; // 1 day

    public static <T> String generateToken(T data) {
        return Jwts.builder()
                .claims(Map.of("data", data))
                .issuer("ClickHouse Backend")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public static Jws<Claims> validateToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
    }

}
