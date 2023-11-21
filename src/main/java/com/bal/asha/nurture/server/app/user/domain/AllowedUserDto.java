package com.bal.asha.nurture.server.app.user.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class AllowedUserDto {


    private String emailId;
    private AllowedUserStatus status;
    private UserType type;

}
