package com.java.Incidents.service;


import com.java.Incidents.controller.dto.RoleDTO;
import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.model.Role;

import java.util.List;

import com.java.Incidents.model.User;

import com.java.Incidents.repository.RoleRepository;
import com.java.Incidents.service.servicesInterface.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;



    @Override
    public List<RoleDTO> findAllRoles() {
        List<Role> rolesEntity = roleRepository.findAll();
        return rolesEntity.stream().map(a -> new RoleDTO(a.getId(), a.getRole())).collect(Collectors.toList());
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<UserDTO> getUsersByRole(String role) {
        Role roleEntity = roleRepository.findByRole(role);
        List<User> users = roleEntity.getUsers();
        List<UserDTO> userDTOList = users.stream()
                .map(a -> new UserDTO(
                        a.getId(),
                        a.getLogin(),
                        a.getPassword(),
                        a.getEmail(),
                        a.getFirstName(),
                        a.getLastName(),
                        a.getPatronymic(),
                        a.getPhoneNumber(),
                        a.getRole().getRole()
                ))
                .collect(Collectors.toList());

        return userDTOList;
    }
}

