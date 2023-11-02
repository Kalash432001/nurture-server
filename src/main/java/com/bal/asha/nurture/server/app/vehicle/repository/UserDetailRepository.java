package com.bal.asha.nurture.server.app.vehicle.repository;

import com.bal.asha.nurture.server.app.vehicle.domain.vo.CompositeOutputVO;
import com.bal.asha.nurture.server.app.vehicle.dto.UserDetailDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bal.asha.nurture.server.app.vehicle.domain.User_Detail;

import java.time.LocalDate;
import java.util.Set;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface UserDetailRepository extends JpaRepository<User_Detail, Integer> {

    @QueryHints(@QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    @Query("select new com.bal.asha.nurture.server.app.vehicle.dto.UserDetailDTO( userId, userName, idProofType, idDtls,address, mobileNo, userType,createDate) from User_Detail")
    Set<UserDetailDTO> getAllUserRecord();



}

