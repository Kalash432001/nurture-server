package com.bal.asha.nurture.server.app.user.domain;

import lombok.Data;

@Data
public class AdditionalUserInfo {

    private boolean newUser;
    private String providerId;
    private Profile profile;
}
