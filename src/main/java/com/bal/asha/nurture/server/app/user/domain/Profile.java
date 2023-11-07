package com.bal.asha.nurture.server.app.user.domain;

import lombok.Data;

@Data
public class Profile {
    private String id;
    private String name;
    private String grantedScopes;
    private String givenName;
    private String locale;
    private String familyName;
    private String email;
    private String picture;
    private boolean verifiedEmail;
}
