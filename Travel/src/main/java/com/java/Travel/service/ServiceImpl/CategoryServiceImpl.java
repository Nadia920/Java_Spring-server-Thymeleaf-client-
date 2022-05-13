package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.CategoryDTO;
import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.model.CategoryEntity;
import com.java.Travel.repository.CategoryRepository;
import com.java.Travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(CategoryDTO categoryDTO) {

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

    @Override
    public List<CategoryDTO> findAll() {
       List<CategoryEntity> list = categoryRepository.findAll();
        return list.stream()
                .map(c -> new CategoryDTO(c.getId(), c.getCategoryName(), c.getDescriptionCategory()))
                .collect(Collectors.toList());
    }


}
