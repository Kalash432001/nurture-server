package com.bal.asha.nurture.server.config.firebase;

import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "create")
public class AuthToken {

    private boolean valid;
    private FirebaseToken token;

    public static AuthToken valid(FirebaseToken decodedToken) {
        return AuthToken.create(true, decodedToken);
    }

    public static AuthToken inValid() {
        return AuthToken.create(false, null);
    }

    public String getEmail(){
        return token.getEmail();
    }
}
