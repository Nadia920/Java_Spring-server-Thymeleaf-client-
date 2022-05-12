package com.java.Incidents.service;

import com.java.Incidents.controller.dto.AppRatingDTO;
import com.java.Incidents.controller.dto.CategoryDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.exception.EditUsersParametersExistException;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.Category;
import com.java.Incidents.model.User;
import com.java.Incidents.repository.AppRatingRepository;
import com.java.Incidents.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository сategoryRepository;

    /*@Transactional
    @Override
    public boolean save(CategoryDTO сategoryDTO) {

        Long idExistUser = сategoryRepository.getIdCategoryByCategoryName(сategoryDTO.getCategoryName());
        if (idExistUser != null) {
            throw new EditUsersParametersExistException("User_with_this_email_already_exist", сategoryDTO);
        }

        Category сategory = new Category();
        сategory.setCategoryName(сategoryDTO.getCategoryName());
        сategory.setDescriptionCategory(сategoryDTO.getDescriptionCategory());

        сategoryRepository.save(сategory);

        return true;
    }

    @Override
    public List<CategoryDTO> getCategoryById(Long id) {

        List<Category> сategoryList = сategoryRepository.findAllByCategoryName(Long name);
        List<CategoryDTO> categoryDTOList = categoryList.stream()
                .map(a -> new CategoryDTO(
                        a.getId(),
                        a.getCategoryName(),
                        a.getDescriptionCategory()
                ))
                .collect(Collectors.toList());

        return сategoryDTOList;

    }

    @Transactional
    @Override
    public void deleteCategoryById(Long id) throws UserNotFoundException {
        Optional<Category> categoryEntity = сategoryRepository.findById(id);

        if (categoryEntity.isPresent()) {
            сategoryRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Category with id=" + id + " not found");
        }
    }

    @Override
    public UserDTO findCategoryById(Long id) {
        Optional<Category> categoryEntity = сategoryRepository.findById(id);
        return categoryEntity.isPresent() ? mapAppRatingDTO(categoryEntity.get()) : null;
    }

    private CategoryDTO mapCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setDescriptionCategory(category.getDescriptionCategory());
        return categoryDTO;
    }

    @Transactional
    @Override
    public void update(CategoryDTO category) {

        Long idExistCategory = categoryRepository.getIdAppRatingByCategoryName(category.getCategoryName());

        if (idExistCategory != null && !idExistCategory.equals(category.getId())) {
            throw new EditCategoryParametersExistException("This_category_already_exists", category);
        }


        Optional<Category> editCategoryEntity = categoryRepository.findById(category.getId());
        if (editCategoryEntity.isPresent()) {

            editCategoryEntity.get().setCategoryName(category.getCategoryName());
            editCategoryEntity.get().setDescriptionCategory(category.getDescriptionCategory());

            categoryRepository.save(editCategoryEntity.get());
        } else {
            throw new UserNotFoundException("Category with id=" + category.getId() + " not found");
        }

    }*/
}
