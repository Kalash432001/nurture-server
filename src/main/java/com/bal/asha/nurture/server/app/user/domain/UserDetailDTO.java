package com.bal.asha.nurture.server.app.user.domain;

import com.bal.asha.nurture.server.app.user.domain.entity.UserAddress;
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
        private UserAddress address;
        private String mobileNo;
        private String userType;
        private LocalDateTime createDate;



}
