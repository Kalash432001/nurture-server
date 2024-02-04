package com.bal.asha.nurture.server.app.child.domain.entity;


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
public class ChildDetails {

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

    public static ChildDetails create(String childId, String childName, String idProof, String area, LocalDate createDate, LocalDate dateOfBirth) {
        ChildDetails o = new ChildDetails();
        o.childName = childName;
        o.idProof = idProof;
        o.area = area;
        o.createDate = createDate;
        o.dateOfBirth = dateOfBirth;
        return o;
    }

}
