package com.bal.asha.nurture.server.app.user.repository;

import com.bal.asha.nurture.server.app.user.dto.UserDetailDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bal.asha.nurture.server.app.user.table.UserDetail;

import java.util.Set;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    @QueryHints(@QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    @Query("select new com.bal.asha.nurture.server.app.user.dto.UserDetailDTO( userId, userName, idProofType, idDtls,address, mobileNo, userType,createDate) from UserDetail")
    Set<UserDetailDTO> getAllUserRecord();



}

