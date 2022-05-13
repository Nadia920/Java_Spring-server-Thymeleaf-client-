package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.CategoryDTO;
import com.java.Travel.repository.AppRatingRepository;
import com.java.Travel.repository.CategoryRepository;
import com.java.Travel.service.AppRatingService;
import com.java.Travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean save(CategoryDTO categoryDTO) {
        return false;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public CategoryDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(CategoryDTO categoryDTO) {

    }
}
