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
public class CaseDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "case_ID", nullable = false)
    private int caseId;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "child_id", nullable = false)
    private int childId;

    @Column(name = "worker_id")
    private int workerId;

    @Column(name = "urgency")
    private String urgency;

    @Column(name = "from_date")
    private LocalDate fromDate;


    @Column(name = "to_date")
    private LocalDate toDate;

    public static CaseDetails create(int caseId, String category, int childId, int workerId ,String urgency, LocalDate fromDate, LocalDate toDate) {
        CaseDetails o = new CaseDetails();
        o.caseId = caseId;
        o.category = category;
        o.childId = childId;
        o.workerId = workerId;
        o.urgency = urgency;
        o.fromDate = fromDate;
        o.toDate = toDate;
        return o;
    }

}
