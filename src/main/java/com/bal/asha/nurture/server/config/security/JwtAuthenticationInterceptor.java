package com.bal.asha.nurture.server.config.security;

import com.bal.asha.nurture.server.config.firebase.AuthToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        // Your authentication logic here
        // Check if the "Authorization" header is present and contains a valid JWT token.

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7); // Remove "Bearer " prefix

            // Validate the JWT token (you need to implement this)
            AuthToken verifiedToken = isValidToken(jwtToken);
            if (verifiedToken.isValid()) {
                //SecurityContext securityContext = SecurityContextHolder.getContext();
                return true; // Continue processing the request
            }
        }

        // If the token is not valid or missing, send an unauthorized response
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    private AuthToken isValidToken(String token) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            return AuthToken.valid(decodedToken);
        } catch (FirebaseAuthException e) {
            log.error("Invalid Token", e);
            return AuthToken.inValid();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // This method can be left empty or used for post-processing if needed.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // This method can be left empty or used for post-processing if needed.
    }
}

