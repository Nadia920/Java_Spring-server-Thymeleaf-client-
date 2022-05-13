package com.java.Incidents.service.servicesInterface;



import com.java.Incidents.controller.dto.CompanyDTO;
import com.java.Incidents.controller.dto.IncidentDTO;


import java.util.List;

public interface InfoService {
    List<IncidentDTO> getDataForTour();

    List<CompanyDTO> getDataForIncident();
}

