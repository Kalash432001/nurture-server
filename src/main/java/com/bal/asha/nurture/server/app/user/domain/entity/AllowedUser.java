package com.bal.asha.nurture.server.app.user.domain.entity;


import com.bal.asha.nurture.server.app.user.domain.AllowedUserStatus;
import com.bal.asha.nurture.server.app.user.domain.UserType;
import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AllowedUser extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllowedUserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType type;

    public AllowedUser disable() {
        status = AllowedUserStatus.DISABLED;
        return this;
    }

    public AllowedUser activate() {
        status = AllowedUserStatus.ACTIVE;
        return this;
    }

    public AllowedUser updateType(UserType type) {
        this.type = type;
        return this;
    }
}
