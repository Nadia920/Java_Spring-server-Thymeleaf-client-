package com.java.Incidents.service.servicesInterface;



import com.java.Incidents.controller.dto.RoleDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.model.Role;


import java.util.List;

public interface RoleService {


    List<RoleDTO> findAllRoles();

    Role findByRole(String role);

    List<UserDTO> getUsersByRole(String role);
}
