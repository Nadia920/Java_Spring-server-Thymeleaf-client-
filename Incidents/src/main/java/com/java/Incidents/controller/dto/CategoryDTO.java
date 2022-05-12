package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Incidents;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class CategoryDTO {

    private Set<Incidents> incidents;

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
