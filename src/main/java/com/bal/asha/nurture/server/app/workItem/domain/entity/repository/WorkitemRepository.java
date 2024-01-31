package com.bal.asha.nurture.server.app.workitem.domain.entity.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bal.asha.nurture.server.app.workitem.domain.entity.Workitem;
import com.bal.asha.nurture.server.common.domain.CustomRepository;

@Repository
public interface WorkitemRepository extends CustomRepository<Workitem, UUID> {

}

