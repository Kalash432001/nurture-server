package com.bal.asha.nurture.server.app.workItem.domain.entity;


import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class WorkItem extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

       
    @Id
    @Column(name = "workItem_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workItemId;

    @Column(name = "workItem_name", nullable = false)
    private String workItemName;   
    
    

   
}
