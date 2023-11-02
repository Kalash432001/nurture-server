package com.bal.asha.nurture.server.app.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO {



        private int userId;
        private String userName;
        private String idProofType;
        private String idDtls;
        private String address;
        private int mobileNo;
        private String userType;
        private LocalDate createDate;




}
