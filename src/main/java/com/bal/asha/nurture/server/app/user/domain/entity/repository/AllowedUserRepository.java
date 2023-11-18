package com.bal.asha.nurture.server.app.user.domain.entity.repository;

import com.bal.asha.nurture.server.common.domain.CustomRepository;
import com.bal.asha.nurture.server.app.user.domain.entity.AllowedUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowedUserRepository extends CustomRepository<AllowedUser, String> {

}

