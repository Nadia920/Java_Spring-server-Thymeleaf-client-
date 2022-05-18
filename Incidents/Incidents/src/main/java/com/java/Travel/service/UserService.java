package com.java.Travel.service;

import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean save(UserEntity userEntity, String role);

    List<UserDTO> getUsersByRole(String role);

    void deleteUserById(Long id);

    UserDTO findUserById(Long id);

    void update(UserEntity user);

    Optional<UserEntity> findByLogin(String login);
    
    UserEntity findByLogin1(String login);

    boolean save (UserEntity obj);
    
    List<UserEntity> findAll();
    
    UserEntity findUserById1(Long id);

    UserEntity findById(long userEntity);


}
