package com.java.Travel.exception;

import com.java.Travel.controller.dto.IncidentCreateUpdateDTO;

public class OrderOnThisBusStationAlreadyExistException extends RuntimeException {
    IncidentCreateUpdateDTO orderDTO;

    public OrderOnThisBusStationAlreadyExistException(String msg, IncidentCreateUpdateDTO orderDTO) {
        super(msg);
        this.orderDTO = orderDTO;
    }
}
