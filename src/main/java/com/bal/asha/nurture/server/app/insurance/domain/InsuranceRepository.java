package com.bal.asha.nurture.server.app.insurance.domain;

import com.bal.asha.nurture.server.common.domain.CustomRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CustomRepository<Insurance, Integer>, JpaSpecificationExecutor<Insurance> {
}
