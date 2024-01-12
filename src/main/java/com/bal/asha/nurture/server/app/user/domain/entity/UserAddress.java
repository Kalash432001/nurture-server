package com.bal.asha.nurture.server.app.user.domain.entity;

import jakarta.persistence.Column;

import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.apache.qpid.proton.engine.Collector;
import org.checkerframework.common.aliasing.qual.Unique;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Set;

@Getter
@Embeddable
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

//    @Column(name = "user_email", nullable = false)
//    private String userEmail;


    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;
}
