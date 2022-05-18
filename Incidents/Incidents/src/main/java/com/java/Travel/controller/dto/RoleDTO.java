package com.java.Travel.controller.dto;


import com.java.Travel.model.RoleEntity;
import lombok.Data;

@Data
public class RoleDTO {

    private Long id;
    private String role;

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }
}


