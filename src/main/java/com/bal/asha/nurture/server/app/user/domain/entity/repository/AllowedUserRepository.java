package com.bal.asha.nurture.server.app.user.domain.entity.repository;

import com.bal.asha.nurture.server.app.user.domain.AllowedUserStatus;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import com.bal.asha.nurture.server.common.domain.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AllowedUserRepository extends CustomRepository<AllowedUser, UUID> {

    boolean existsByEmailIdAndStatus(String email, AllowedUserStatus status);
}

