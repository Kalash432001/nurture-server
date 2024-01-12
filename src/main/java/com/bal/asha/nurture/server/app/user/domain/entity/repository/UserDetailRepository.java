package com.bal.asha.nurture.server.app.user.domain.entity.repository;

import com.bal.asha.nurture.server.app.vehicle.domain.record.VehicleRecord;
import com.bal.asha.nurture.server.common.domain.CustomRepository;
import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface UserDetailRepository extends CustomRepository<UserDetail, Integer> {

    @QueryHints(@QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    @Query("select new com.bal.asha.nurture.server.app.user.domain.entity.UserDetail( userId, userName, userEmail,idProofType, idDtls,address, mobileNo, userType,createdDate) from UserDetail")
    Set<UserDetailDTO> getAllUserRecord();


    @Transactional(readOnly= true)
    UserDetail findByUserEmail(String userEmail);

    @Query("Select count(userEmail)=1 from UserDetail u where userEmail=?1")
    boolean findExistByUserEmail(String userEmail);

}

