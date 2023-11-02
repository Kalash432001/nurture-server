package com.bal.asha.nurture.server.app.vehicle.domain;


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
public class User_Detail {

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
    private int mobileNo;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "create_date")
    private LocalDate createDate;


    public static User_Detail create(String userName, String idProofType, String idDtls, String address, int mobileNo, String userType, LocalDate createDate) {
        User_Detail o = new User_Detail();
        o.userName = userName;
        o.idProofType = idProofType;
        o.idDtls = idDtls;
        o.address = address;
        o.mobileNo = mobileNo;
        o.userType = userType;
        o.createDate = createDate;
        return o;
    }

}
