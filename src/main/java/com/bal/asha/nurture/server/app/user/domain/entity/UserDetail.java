package com.bal.asha.nurture.server.app.user.domain.entity;


import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDetail extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", nullable = false)
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


    public UserDetail(String userName, String idProofType, String idDtls, String address, String mobileNo, String userType) {
        this.userName = userName;
        this.idProofType = idProofType;
        this.idDtls = idDtls;
        this.address = address;
        this.mobileNo = mobileNo;
        this.userType = userType;
    }

    public static UserDetailDTO toUserDetailDTO(UserDetail userDetail) {

        return new UserDetailDTO(userDetail.getUserId(), userDetail.getUserName()
                , userDetail.getIdProofType(), userDetail.getIdDtls(), userDetail.getAddress(), userDetail.getMobileNo(), userDetail.getUserType(), userDetail.getCreatedDate());
    }


    public static UserDetail toUserDetail(UserDetailDTO userDetailDTO) {

        return new UserDetail(userDetailDTO.getUserName(), userDetailDTO.getIdProofType(), userDetailDTO.getIdDtls()
                , userDetailDTO.getAddress(),
                userDetailDTO.getMobileNo(), userDetailDTO.getUserType());

    }

}
