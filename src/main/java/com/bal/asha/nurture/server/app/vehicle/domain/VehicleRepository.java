package com.bal.asha.nurture.server.app.vehicle.domain;


import com.bal.asha.nurture.server.app.vehicle.domain.record.VehicleRecord;
import com.bal.asha.nurture.server.app.vehicle.domain.vo.CompositeOutputVO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @QueryHints(@QueryHint(name = HINT_FETCH_SIZE, value = "1000"))
    @Query("select new com.bal.asha.nurture.server.app.vehicle.domain.vo.CompositeOutputVO(v.id,v.type,v.modelCode,v.brandName,v.launchDate,i.insuredBy,i.insuredOn) from Vehicle v, Insurance i where v.id=i.id and v.brandName= :brandName")
    Set<CompositeOutputVO> findAllComposites(@Param("brandName") String brandName);

    @Transactional(readOnly= true)
    Set<VehicleRecord> findByBrandName(String brandName);
    <T> Collection<T> findByBrandName(String brandName, Class<T> type);
    <T> Collection<T> findBy(Class<T> type);

}
