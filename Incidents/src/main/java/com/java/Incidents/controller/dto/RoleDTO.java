package com.java.Incidents.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {

    private Long id;
    private String role;

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDTO() {
    }

}

