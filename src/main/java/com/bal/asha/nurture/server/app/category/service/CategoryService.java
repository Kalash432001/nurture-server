package com.bal.asha.nurture.server.app.category.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bal.asha.nurture.server.app.category.domain.CategoryDTO;
import com.bal.asha.nurture.server.app.category.domain.entity.Category;
import com.bal.asha.nurture.server.app.category.domain.entity.repository.CategoryRepository;
import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import com.bal.asha.nurture.server.common.util.ProjectionUtil;
import com.querydsl.core.types.Predicate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category save(CategoryDTO categoryDto) {
        Category category = ProjectionUtil.map(categoryDto, Category.class);
        return categoryRepository.save(category);
    }

    public Category getCategory(UUID categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new NurtureServerException("Category with Id :" + categoryId + " Doesn't Exists"));
    }

    public Page<Category> search(Predicate spec, Pageable pageable) {
        return categoryRepository.findAll(spec, pageable);
    }
    
    public  List<CategoryDTO> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> CategoryDTO.builder().categoryId(category.getCategoryId()).CategoryName(category.getCategoryName()).build()).collect(Collectors.toList());
    }

}
