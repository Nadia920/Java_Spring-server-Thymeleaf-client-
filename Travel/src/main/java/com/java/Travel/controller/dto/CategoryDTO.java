package com.java.Travel.controller.dto;


import com.java.Travel.model.IncidentsEntity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class CategoryDTO {

    private Set<IncidentsEntity> incidents;

    @NotNull
    private String сategoryName;

    @NotNull
    private String descriptionCategory;

    CategoryDTO(){}

    CategoryDTO(String сategoryName, String descriptionCategory){
        this.сategoryName = сategoryName;
        this.descriptionCategory = descriptionCategory;
    }
}

