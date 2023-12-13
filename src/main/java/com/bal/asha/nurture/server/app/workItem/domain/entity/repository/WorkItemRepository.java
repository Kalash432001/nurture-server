package com.bal.asha.nurture.server.app.workItem.domain.entity.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bal.asha.nurture.server.app.workItem.domain.entity.WorkItem;
import com.bal.asha.nurture.server.common.domain.CustomRepository;

@Repository
public interface WorkItemRepository extends CustomRepository<WorkItem, UUID> {

}

