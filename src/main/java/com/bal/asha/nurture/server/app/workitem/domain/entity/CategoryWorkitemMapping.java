package com.bal.asha.nurture.server.app.workitem.domain.entity;


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
public class CategoryWorkitemMapping extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_workitem_mapping_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryWorkitemMappingId;
    
    
    @Column(name = "workitem_id", nullable = false)
    private int workitemId;

    @Column(name = "category_id", nullable = false)
    private String categoryId;
    
    @Column(name = "sequence_number", nullable = false)
    private String sequenceNumber;
    
    

    
    
    
    

   
}
