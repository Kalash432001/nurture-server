package com.bal.asha.nurture.server.app.user.domain.entity;


import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AllowedUser extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

   public enum Status {
       ACTIVE, DISABLED
   }

    public enum UserType {
        ADMIN, SUPERINTENDENT, WORKER
    }


}
