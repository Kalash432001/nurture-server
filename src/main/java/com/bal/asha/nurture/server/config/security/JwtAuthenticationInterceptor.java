package com.bal.asha.nurture.server.config.security;

import com.bal.asha.nurture.server.app.user.service.AllowedUserService;
import com.bal.asha.nurture.server.config.firebase.AuthToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@AllArgsConstructor
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    private AllowedUserService allowedUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        if(request.getMethod().equals("OPTIONS") || isSwagger(request)){
            return true;
        }

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7); // Remove "Bearer " prefix

            // Validate the JWT token (you need to implement this)
            AuthToken verifiedToken = isValidToken(jwtToken);
            if (verifiedToken.isValid()) {
                if(allowedUser(verifiedToken.getEmail())) {
                    System.out.println("Hiii from JWT "+ verifiedToken.getEmail());
                    updateProfilePicUri(verifiedToken.getEmail(), verifiedToken.getProfilePictureUri());
                    return true; // Continue processing the request
                }else{
                    log.error("User : {} not allowed", verifiedToken.getEmail());
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
            }
        }

        // If the token is not valid or missing, send an unauthorized response
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    private void updateProfilePicUri(String email, String profilePictureUri) {
        allowedUserService.updateProfilePicUri(email, profilePictureUri);
    }

    private boolean allowedUser(String email) {
        return allowedUserService.isAllowed(email);
    }

    private boolean isSwagger(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return uri.contains("api-docs") || uri.contains("swagger");
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

