package io.akshayraj.interceptors;

import io.akshayraj.models.UserModel;
import io.akshayraj.services.AuthService;
import io.akshayraj.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class JwtAuthInterceptor implements HandlerInterceptor {

    private final AuthService authService;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        if (request.getRequestURL().toString().startsWith("/api/auth")) {
            return true;
        }

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            Jws<Claims> claims = JwtUtil.validateToken(token);
            UserModel user = JwtUtil.convert(claims.getPayload(), UserModel.class);
            String username = user.getUsername();
            if (authService.getUser(username).isPresent()) {
                request.setAttribute("username", username);
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
