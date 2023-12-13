package com.bal.asha.nurture.server.app.category.controller;

import com.bal.asha.nurture.server.app.category.domain.CategoryDTO;
import com.bal.asha.nurture.server.app.category.service.CategoryService;
import com.bal.asha.nurture.server.app.user.domain.UserDetailDTO;
import com.bal.asha.nurture.server.app.user.domain.entity.UserDetail;
import com.bal.asha.nurture.server.app.user.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@Slf4j
@Validated
@RestController
@AllArgsConstructor
public class CategoryDetailController {

	private CategoryService categoryService;
	  
	@GetMapping("/get-categories")
    public List<CategoryDTO> getAllCaegories(){
        return categoryService.getAllCategories();
    }

}


