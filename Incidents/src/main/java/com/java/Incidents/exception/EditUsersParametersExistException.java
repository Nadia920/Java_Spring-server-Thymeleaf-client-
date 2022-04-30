package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.UserDTO;


public class EditUsersParametersExistException extends RuntimeException {

    UserDTO userDTO;

    public EditUsersParametersExistException(String message, UserDTO userDTO) {
        super(message);
        this.userDTO = userDTO;
    }
}
