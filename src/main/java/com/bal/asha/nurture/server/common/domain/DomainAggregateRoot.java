package com.bal.asha.nurture.server.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public abstract class DomainAggregateRoot {


    @CreatedBy
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9_@\\.]*$", message = "Invalid created by name '${validatedValue}', permissible characters are alphanumerical, underscore and hyphen.")
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9_@\\.]*$", message = "Invalid last modified by name '${validatedValue}', permissible characters are alphanumerical, underscore and hyphen.")
    @Column(name = "last_modified_by", length = 50)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String lastModifiedBy;


    @LastModifiedDate
    @Column(name = "last_modified_date", updatable = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LocalDateTime lastModifiedDate;

    @Version
    private Integer version;
}
