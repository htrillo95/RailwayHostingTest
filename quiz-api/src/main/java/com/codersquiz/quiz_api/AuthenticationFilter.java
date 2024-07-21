package com.codersquiz.quiz_api;

import com.codersquiz.quiz_api.controllers.AuthenticationController;
import com.codersquiz.quiz_api.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter {

    @Autowired
    AuthenticationController authenticationController;

    //whitelist
    private static final List<String> whitelist = Arrays.asList("/", "/api", "/register", "/login");

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals("/") || path.equals(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (isWhitelisted(request.getRequestURI())) {
            return true;

        }
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }

}
