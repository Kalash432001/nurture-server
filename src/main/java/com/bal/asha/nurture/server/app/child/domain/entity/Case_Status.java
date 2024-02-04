package com.bal.asha.nurture.server.app.child.domain.entity;


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
public class Case_Status {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "case_ID", nullable = false)
    private int caseId;

    @Column(name = "status_ID", nullable = false)
    private int statusId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;




    public static Case_Status create(int caseId, int statusId, LocalDate startDate, LocalDate endDate) {
        Case_Status o = new Case_Status();
        o.caseId = caseId;
        o.statusId = statusId;
        o.startDate = startDate;
        o.endDate = endDate;
        return o;
    }

}
