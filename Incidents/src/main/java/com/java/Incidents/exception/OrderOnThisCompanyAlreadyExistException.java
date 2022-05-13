package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.IncidentCreateUpdateDTO;

public class OrderOnThisCompanyAlreadyExistException extends RuntimeException {
    IncidentCreateUpdateDTO orderDTO;

    public OrderOnThisCompanyAlreadyExistException(String msg, IncidentCreateUpdateDTO orderDTO) {
        super(msg);
        this.orderDTO = orderDTO;
    }
}

