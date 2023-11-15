package com.bal.asha.nurture.server.app.user.entity;


import com.bal.asha.nurture.server.app.user.dto.UserDetailDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Setter
@EqualsAndHashCode
@Entity
@ToString
public class UserDetail {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "id_proof_type", nullable = false)
    private String idProofType;

    @Column(name = "id_dtls", nullable = false)
    private String idDtls;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_No", nullable = false)
    private String mobileNo;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "create_date")
    private LocalDate createDate;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public String getIdDtls() {
        return idDtls;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getUserType() {
        return userType;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public UserDetail (String userName, String idProofType, String idDtls, String address, String mobileNo, String userType, LocalDate createDate) {
        this.userName = userName;
        this.idProofType = idProofType;
        this.idDtls = idDtls;
        this.address = address;
        this.mobileNo = mobileNo;
        this.userType = userType;
        this.createDate = createDate;

    }
    public static UserDetailDTO toUserDetailDTO(UserDetail userDetail) {

        return new UserDetailDTO(userDetail.getUserId(),userDetail.getUserName()
                ,userDetail.getIdProofType(),userDetail.getIdDtls(),userDetail.getAddress(),userDetail.getMobileNo(),userDetail.getUserType(),userDetail.getCreateDate());
    }


    public static UserDetail toUserDetail( UserDetailDTO userDetailDTO) {

        return new UserDetail(userDetailDTO.getUserName(), userDetailDTO.getIdProofType(), userDetailDTO.getIdDtls()
                ,userDetailDTO.getAddress(),
                userDetailDTO.getMobileNo(),userDetailDTO.getUserType(), userDetailDTO.getCreateDate());

        }

}
