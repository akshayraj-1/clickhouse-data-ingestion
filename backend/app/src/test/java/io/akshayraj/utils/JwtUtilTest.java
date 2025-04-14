package io.akshayraj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class JwtUtilTest {

    private static final String payload = "Hello World!";

    @Test
    public void testGenerateAndValidateToken() throws Exception {
        // 1. Generate the token
        String token = JwtUtil.generateToken(payload);
        System.out.println("Generated Token: " + token);
        Assertions.assertNotNull(token, "Token should not be null.");

        // 2. Validate the generated token
        Jws<Claims> claimsJws = JwtUtil.validateToken(token);
        System.out.println("Token data: " + claimsJws.getPayload().get("data"));
        Assertions.assertNotNull(claimsJws, "Claims should not be null.");
        Assertions.assertEquals(payload, claimsJws.getPayload().get("data"));
    }

}
