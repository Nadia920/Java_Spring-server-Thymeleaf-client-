package com.java.Travel.exception;

import com.java.Travel.controller.dto.UserDTO;
import com.java.Travel.model.UserEntity;


public class EditUsersParametersExistException extends RuntimeException {

    UserDTO userDTO;

    public EditUsersParametersExistException(String message, UserEntity userEntity) {
        super(message);
        this.userDTO = userDTO;
    }
}
