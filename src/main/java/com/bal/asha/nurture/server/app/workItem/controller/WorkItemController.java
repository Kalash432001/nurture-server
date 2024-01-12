package com.bal.asha.nurture.server.app.workItem.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bal.asha.nurture.server.app.workItem.domain.WorkItemDTO;
import com.bal.asha.nurture.server.app.workItem.service.WorkItemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class WorkItemController {

	private WorkItemService workItemService;
	  
	@GetMapping("/get-workItems")
    public List<WorkItemDTO> getAllWorkItems(){
        return workItemService.getAllWorkItems();
    }

}


