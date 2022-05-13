package com.java.Travel.controller.dto;


import com.java.Travel.model.IncidentsEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
public class CategoryDTO {

    private Long id;

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

    public CategoryDTO(Long id, String сategoryName, String descriptionCategory) {
        this.id = id;
        this.сategoryName = сategoryName;
        this.descriptionCategory = descriptionCategory;
    }
}

