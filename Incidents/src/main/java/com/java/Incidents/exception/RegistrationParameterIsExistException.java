package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.UserDTO;

public class RegistrationParameterIsExistException extends RuntimeException {

    UserDTO userDTO;


    public RegistrationParameterIsExistException(String message, UserDTO userDTO) {
        super(message);
        this.userDTO = userDTO;
    }

}

