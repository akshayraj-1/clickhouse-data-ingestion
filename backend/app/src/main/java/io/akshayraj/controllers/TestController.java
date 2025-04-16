package io.akshayraj.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/")
    public @ResponseBody String root() {
        return "Hello World!";
    }

    @GetMapping("/ping")
    public @ResponseBody String ping() {
        return "pong";
    }

    @GetMapping("/session-info")
    public @ResponseBody Map<String, Object> getSessionInfo(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession(true);
        String sessionId = session.getId();
        result.put("sessionId", sessionId);
        System.out.println("Session ID: " + sessionId);

        List<Map<String, String>> cookieList = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                Map<String, String> cookieData = new HashMap<>();
                cookieData.put("name", cookie.getName());
                cookieData.put("value", cookie.getValue());
                cookieList.add(cookieData);
                System.out.println("Cookie received: " + cookie.getName() + " = " + cookie.getValue());
            }
        } else {
            System.out.println("No cookies received");
        }

        result.put("receivedCookies", cookieList);
        session.setAttribute("testKey", "Hello from server");
        result.put("testKey", session.getAttribute("testKey"));

        return result;
    }

}
