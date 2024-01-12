package com.bal.asha.nurture.server.app.user.domain.entity;


import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Set;

@Getter
@Entity
@Setter
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

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "id_proof_type")
    private String idProofType;

    @Column(name = "id_dtls")
    private String idDtls;

    @Embedded
    @Column(name="address")
    private UserAddress address;

    @Column(name = "mobile_No")
    private String mobileNo;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Override
    public Integer getVersion() {
        // Overriding method in the subclass with a different return type
        return 0;
    }


    public static UserDetailDTO toUserDetailDTO(UserDetail userDetail) {

        return new UserDetailDTO( userDetail.getUserName() ,userDetail.getUserEmail()
                , userDetail.getIdProofType(), userDetail.getIdDtls(), userDetail.getAddress(), userDetail.getMobileNo(), userDetail.getUserType(), userDetail.getCreatedDate());
    }


    public static UserDetail toUserDetail(UserDetailDTO userDetailDTO) {

        return new UserDetail(0,userDetailDTO.getUserName(),userDetailDTO.getUserEmail(), userDetailDTO.getIdProofType(), userDetailDTO.getIdDtls(), userDetailDTO.getAddress(),
                userDetailDTO.getMobileNo(), userDetailDTO.getUserType(), userDetailDTO.getCreateDate());

    }


    public static Set<UserDetailDTO> toUserDetailDTO(Set<UserDetail> userDetailSet) {

        return userDetailSet.stream().map(user-> new UserDetailDTO(user.getUserName() ,user.getUserEmail()
                , user.getIdProofType(), user.getIdDtls(), user.getAddress(), user.getMobileNo(), user.getUserType(), user.getCreateDate())).collect(Collectors.toSet());
    }


}
