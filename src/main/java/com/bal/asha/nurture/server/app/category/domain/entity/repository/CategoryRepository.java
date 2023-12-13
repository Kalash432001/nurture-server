package com.bal.asha.nurture.server.app.category.domain.entity.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.bal.asha.nurture.server.app.category.domain.entity.Category;
import com.bal.asha.nurture.server.common.domain.CustomRepository;

@Repository
public interface CategoryRepository extends CustomRepository<Category, UUID> {

}

