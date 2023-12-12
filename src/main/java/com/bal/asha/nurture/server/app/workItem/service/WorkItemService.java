package com.bal.asha.nurture.server.app.workItem.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bal.asha.nurture.server.app.category.domain.CategoryDTO;
import com.bal.asha.nurture.server.app.category.domain.entity.Category;
import com.bal.asha.nurture.server.app.category.domain.entity.repository.CategoryRepository;
import com.bal.asha.nurture.server.app.workItem.domain.WorkItemDTO;
import com.bal.asha.nurture.server.app.workItem.domain.entity.WorkItem;
import com.bal.asha.nurture.server.app.workItem.domain.entity.repository.WorkItemRepository;
import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import com.bal.asha.nurture.server.common.util.ProjectionUtil;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WorkItemService {

    private WorkItemRepository workItemRepository;

    public WorkItem save(WorkItemDTO workItemDTO) {
        WorkItem workItem = ProjectionUtil.map(workItemDTO, WorkItem.class);
        return workItemRepository.save(workItem);
    }

        
    public  List<WorkItemDTO> getAllWorkItems(){
        List<WorkItem> workItems = workItemRepository.findAll();
        return workItems.stream().map(workItem -> WorkItemDTO.builder().workItemId(workItem.getWorkItemId()).workItemName(workItem.getWorkItemName()).build()).collect(Collectors.toList()); 
    }

}
