package com.bal.asha.nurture.server.app.workitem.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bal.asha.nurture.server.app.workitem.domain.WorkitemDTO;
import com.bal.asha.nurture.server.app.workitem.service.WorkitemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class WorkitemController {

	private WorkitemService workitemService;
	  
	@GetMapping("/get-workitems")
    public List<WorkitemDTO> getAllWorkitems(){
        return workitemService.getAllWorkitems();
    }

}


