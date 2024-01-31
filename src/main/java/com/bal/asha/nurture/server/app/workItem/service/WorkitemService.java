package com.bal.asha.nurture.server.app.workitem.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bal.asha.nurture.server.app.category.domain.CategoryDTO;
import com.bal.asha.nurture.server.app.category.domain.entity.Category;
import com.bal.asha.nurture.server.app.category.domain.entity.repository.CategoryRepository;
import com.bal.asha.nurture.server.app.workitem.domain.WorkitemDTO;
import com.bal.asha.nurture.server.app.workitem.domain.entity.Workitem;
import com.bal.asha.nurture.server.app.workitem.domain.entity.repository.WorkitemRepository;
import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import com.bal.asha.nurture.server.common.util.ProjectionUtil;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class WorkitemService {

    private WorkitemRepository workitemRepository;

    public Workitem save(WorkitemDTO workitemDTO) {
        Workitem workitem = ProjectionUtil.map(workitemDTO, Workitem.class);
        return workitemRepository.save(workitem);
    }

        
    public  List<WorkitemDTO> getAllWorkitems(){
        List<Workitem> workitems = workitemRepository.findAll();
        return workitems.stream().map(workitem -> WorkitemDTO.builder().workitemId(workitem.getWorkitemId()).workitemName(workitem.getWorkitemName()).build()).collect(Collectors.toList()); 
    }

}
