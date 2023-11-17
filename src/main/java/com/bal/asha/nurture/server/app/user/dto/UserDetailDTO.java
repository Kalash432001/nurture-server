package com.bal.asha.nurture.server.app.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public class UserDetailDTO {



        private int userId;
        private String userName;
        private String idProofType;
        private String idDtls;
        private String address;
        private String mobileNo;
        private String userType;
        private LocalDate createDate;

        public UserDetailDTO(int userId , String userName, String idProofType, String idDtls, String address, String mobileNo, String userType, LocalDate createDate) {
                this.userId = userId;
                this.userName = userName;
                this.idProofType = idProofType;
                this.idDtls = idDtls;
                this.address = address;
                this.mobileNo = mobileNo;
                this.userType = userType;
                this.createDate = createDate;
        }
        public UserDetailDTO(String userName, String idProofType, String idDtls, String address, String mobileNo, String userType, LocalDate createDate) {
                this.userName = userName;
                this.idProofType = idProofType;
                this.idDtls = idDtls;
                this.address = address;
                this.mobileNo = mobileNo;
                this.userType = userType;
                this.createDate = createDate;
        }


        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getIdProofType() {
                return idProofType;
        }

        public void setIdProofType(String idProofType) {
                this.idProofType = idProofType;
        }

        public String getIdDtls() {
                return idDtls;
        }

        public void setIdDtls(String idDtls) {
                this.idDtls = idDtls;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getMobileNo() {
                return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
                this.mobileNo = mobileNo;
        }

        public String getUserType() {
                return userType;
        }

        public void setUserType(String userType) {
                this.userType = userType;
        }

        public LocalDate getCreateDate() {
                return createDate;
        }

        public void setCreateDate(LocalDate createDate) {
                this.createDate = createDate;
        }
}
