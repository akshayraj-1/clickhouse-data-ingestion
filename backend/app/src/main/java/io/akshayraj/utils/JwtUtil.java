package io.akshayraj.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final SecretKey key = Keys.hmacShaKeyFor("8098b04f1591edd3b75f4ae10f4ebaa01b0b3c562db66b945af1eeb55ddd3b11".getBytes());
    private static final long expiration = 1000 * 60 * 60 * 24; // 1 day

    public static <T> String generateToken(T data) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        return Jwts.builder()
                .claim("data", objMapper.writeValueAsString(data))
                .issuer("ClickHouse Backend")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public static Jws<Claims> validateToken(@NotNull String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
    }

    public static <T> T convert(Claims claims, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(claims.get("data").toString(), clazz);
    }

}
