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
    Set<UserDetail> getAllUserRecord();


//    @Query("select new com.bal.asha.nurture.server.app.user.domain.entity.UserDetail( userId, userName, userEmail,idProofType, idDtls,address, mobileNo, userType,createdDate) from UserDetail u where u.userEmail= :user_email")
//    UserDetail findByUserEmail(@Param("user_email") String user_email);

    @Transactional(readOnly= true)
    UserDetail findByUserEmail(String userEmail);

//    @Modifying
//    @Query("update om.bal.asha.nurture.server.app.user.domain.entity.UserDetail u set u.status = :status where u.name = :name")
//    int updateUserSetStatusForName(@Param("status") Integer status,
//                                   @Param("name") String name);


}

