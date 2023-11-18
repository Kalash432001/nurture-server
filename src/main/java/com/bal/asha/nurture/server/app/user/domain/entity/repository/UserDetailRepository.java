package com.bal.asha.nurture.server.app.user.domain.entity.repository;

import com.bal.asha.nurture.server.common.domain.CustomRepository;
import com.bal.asha.nurture.server.app.user.domain.dto.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.Set;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface UserDetailRepository extends CustomRepository<UserDetail, Integer> {

    @QueryHints(@QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    @Query("select new com.bal.asha.nurture.server.app.user.domain.dto.UserDetailDTO( userId, userName, idProofType, idDtls,address, mobileNo, userType,createdDate) from UserDetail")
    Set<UserDetailDTO> getAllUserRecord();



}

