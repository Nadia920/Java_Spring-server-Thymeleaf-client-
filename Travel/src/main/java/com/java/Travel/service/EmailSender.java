package com.java.Travel.service;


import com.java.Travel.controller.dto.IncidentDTO;

public interface EmailSender {
    void sendСonfirmPurchaseToEmail(IncidentDTO orderDTO);

    void sendСancellationСonfirmToEmail(IncidentDTO orderDTO);
}
