package com.bal.asha.nurture.server.app.vehicle.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Setter
@EqualsAndHashCode
@Entity
@ToString
public class Child_Dtls {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "child_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int childId;

    @Column(name = "child_name", nullable = false)
    private String childName;

    @Column(name = "id_proof", nullable = false)
    private String idProof;

    @Column(name = "area")
    private String area;

    @Column(name = "create_date")
    private LocalDate createDate;


    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public static Child_Dtls create(String childId, String childName, String idProof, String area, LocalDate createDate, LocalDate dateOfBirth) {
        Child_Dtls o = new Child_Dtls();
        o.childName = childName;
        o.idProof = idProof;
        o.area = area;
        o.createDate = createDate;
        o.dateOfBirth = dateOfBirth;
        return o;
    }

}
