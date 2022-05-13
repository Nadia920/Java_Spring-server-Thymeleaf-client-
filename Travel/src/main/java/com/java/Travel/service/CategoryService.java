package com.java.Travel.service;

import com.java.Travel.controller.dto.CategoryDTO;

public interface CategoryService {
    boolean save(CategoryDTO categoryDTO);

    void deleteUserById(Long id);

    CategoryDTO findUserById(Long id);

    void update(CategoryDTO categoryDTO);
}
