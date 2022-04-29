package com.java.Incidents.service.servicesInterface;


import com.java.Travel.controller.dto.OrderDTO;

public interface EmailSender {
    void sendСonfirmPurchaseToEmail(OrderDTO orderDTO);

    void sendСancellationСonfirmToEmail(OrderDTO orderDTO);
}

