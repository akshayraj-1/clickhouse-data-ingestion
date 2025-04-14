package io.akshayraj.controllers;

import io.akshayraj.dto.ApiResponse;
import io.akshayraj.dto.AuthenticateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/authenticate")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody AuthenticateRequest authenticateRequest) {

        return null;
    }

}
