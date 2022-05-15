package com.java.Travel.service;

import com.java.Travel.controller.dto.AppRatingDTO;
import com.java.Travel.controller.dto.CategoryDTO;
import com.java.Travel.model.CategoryEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {

    @Transactional
    void save(CategoryDTO categoryDTO);

    void deleteUserById(Long id);

    CategoryDTO findUserById(Long id);

    void update(CategoryDTO categoryDTO);

    List<CategoryEntity> findAll();
    
    CategoryEntity findById(Long id);
    
    boolean save(CategoryEntity obj);
}
