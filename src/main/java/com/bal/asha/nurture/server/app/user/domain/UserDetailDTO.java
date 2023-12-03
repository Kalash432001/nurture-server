package com.bal.asha.nurture.server.app.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {


        private String userName;
        private String userEmail;
        private String idProofType;
        private String idDtls;
        private String address;
        private String mobileNo;
        private String userType;
        private LocalDateTime createDate;



}
