package com.java.Travel.service;

import com.java.Travel.controller.dto.IncidentCreateUpdateDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IncidentService {

    IncidentDTO add(IncidentCreateUpdateDTO incidentDTO);

    List<IncidentDTO> getOrdersByUserId(Long id);

    IncidentDTO findById(Long id);

    void deleteTicketsOnTripByUSer(IncidentCreateUpdateDTO order);

    IncidentDTO takeMoreTickets(IncidentCreateUpdateDTO order);

    List<IncidentDTO> findAllByTripId(Long idTrip);

    List<IncidentDTO> getOrdersByUserIdAndStatus(Long id, IncidentStatus status);

    List<IncidentDTO> getIncidentsFalse(String name);

    List<IncidentDTO> getIncidentsTrue(String name);

    List<IncidentDTO> getIncidents();

    List<IncidentDTO> getIncidentsByIncidentName(String name1);

    String getIncidentsReactionByID(Long id);

    List<IncidentDTO> findALL();

    @Transactional
    void save(IncidentDTO incidentDTO);

    boolean save(IncidentsEntity incidentEntity);
}
