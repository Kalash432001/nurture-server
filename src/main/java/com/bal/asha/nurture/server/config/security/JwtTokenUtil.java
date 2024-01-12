package com.bal.asha.nurture.server.config.security;


import com.bal.asha.nurture.server.config.firebase.AuthToken;
import com.bal.asha.nurture.server.config.firebase.AuthToken;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {

    private AuthToken isValidToken(String token) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
            return AuthToken.valid(decodedToken);
        } catch (FirebaseAuthException e){
            return AuthToken.inValid();
        }
    }

    public String getUserEmail(String jwtToken){
        AuthToken verifiedToken = isValidToken(jwtToken);
        return verifiedToken.getEmail();
    }
}
