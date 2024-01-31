package com.bal.asha.nurture.server.app.child.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@EqualsAndHashCode
@Entity
@ToString
public class ChildWorkitemStatus {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "child_workitem_status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int childWorkitemStatusId;

    @Column(name = "child_ID", nullable = false)
    private int childId;
    
    @Column(name = "workitem_id", nullable = false)
    private int workitemId;

    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;

}
