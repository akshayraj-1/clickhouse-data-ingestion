package io.akshayraj.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.akshayraj.dto.AuthRequest;
import io.akshayraj.dto.AuthResponse;
import io.akshayraj.models.UserModel;
import io.akshayraj.repositories.UserRepository;
import io.akshayraj.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public AuthResponse signUp(AuthRequest authRequest) throws IllegalArgumentException,
            JsonProcessingException {
        if (userRepository.existsByUsername(authRequest.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        UserModel user = new UserModel();
        user.setUsername(authRequest.getUsername());
        user.setPassword(authRequest.getPassword());
        userRepository.save(user);
        String token = JwtUtil.generateToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest authRequest) throws IllegalArgumentException,
            JsonProcessingException {
        Optional<UserModel> user = userRepository.findByUsername(authRequest.getUsername());
        if (user.isPresent()) {
            String password = user.get().getPassword();
            if (password.equals(authRequest.getPassword())) {
                String token = JwtUtil.generateToken(user.get());
                return new AuthResponse(token);
            } else {
                throw new IllegalArgumentException("Invalid credentials");
            }
        }
        throw new IllegalArgumentException("User not found");
    }

    public Optional<UserModel> getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
