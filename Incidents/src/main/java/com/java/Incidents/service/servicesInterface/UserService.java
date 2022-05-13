package com.java.Incidents.service.servicesInterface;


import com.java.Incidents.controller.dto.UserDTO;
import com.java.Incidents.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean save(UserDTO userDTO, String role);

    List<UserDTO> getUsersByRole(String role);

    void deleteUserById(Long id);

    UserDTO findUserById(Long id);

    void update(UserDTO user);

    Optional<User> findByLogin(String login);
}
