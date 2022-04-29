package com.java.Incidents.service.servicesInterface;



import com.java.Travel.controller.dto.RoleDTO;
import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.model.RoleEntity;

import java.util.List;

public interface RoleService {


    List<RoleDTO> findAllRoles();

    RoleEntity findByRole(String role);

    List<UserDTO> getUsersByRole(String role);
}
