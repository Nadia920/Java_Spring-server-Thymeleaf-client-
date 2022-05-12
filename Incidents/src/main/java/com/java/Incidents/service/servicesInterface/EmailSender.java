package com.java.Incidents.service.servicesInterface;


import com.java.Incidents.controller.dto.IncidentDTO;

public interface EmailSender {
    void sendСonfirmPurchaseToEmail(IncidentDTO incidentDTO);

    void sendСancellationСonfirmToEmail(IncidentDTO incidentDTO);
}

