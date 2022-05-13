package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.AppRatingDTO;
import com.java.Incidents.controller.dto.CategoryDTO;

public interface CategoryService {
    boolean save(CategoryDTO categoryDTO);

    void deleteUserById(Long id);

    CategoryDTO findUserById(Long id);

    void update(CategoryDTO categoryDTO);
}
