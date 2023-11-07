package com.bal.asha.nurture.server.app.user.domain;

import lombok.Data;

@Data
public class UserDetails {
    private String token;
    private AdditionalUserInfo additionalUserInfo;
}
