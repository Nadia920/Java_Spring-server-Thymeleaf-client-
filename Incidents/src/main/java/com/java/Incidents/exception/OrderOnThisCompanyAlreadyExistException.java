package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.OrderCreateUpdateDTO;
import com.java.Incidents.controller.dto.OrderCreateUpdateDTO;

public class OrderOnThisCompanyAlreadyExistException extends RuntimeException {
    OrderCreateUpdateDTO orderDTO;

    public OrderOnThisCompanyAlreadyExistException(String msg, OrderCreateUpdateDTO orderDTO) {
        super(msg);
        this.orderDTO = orderDTO;
    }
}

