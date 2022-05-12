package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.IncidentCreateUpdateDTO;
import com.java.Incidents.controller.dto.IncidentCriteriaDTO;
import com.java.Incidents.controller.dto.IncidentDTO;
import com.java.Incidents.model.IncidentStatus;

import java.util.List;

public interface IncidentService {
    IncidentDTO add(IncidentCreateUpdateDTO orderDTO);

    List<IncidentDTO> getOrdersByUserId(Long id);

    IncidentDTO findById(Long id);

    void deleteTicketsOnTripByUSer(IncidentCreateUpdateDTO order);

    IncidentDTO takeMoreTickets(IncidentCreateUpdateDTO order);

    List<IncidentDTO> findAllByTripId(Long idTrip);

    List<IncidentDTO> getOrdersByUserIdAndStatus(Long id, IncidentStatus status);

    IncidentDTO getById(Long id);

    void addIncident(IncidentCreateUpdateDTO incidentDTO);

    void edit(IncidentCreateUpdateDTO incidentDTO);

    List<IncidentDTO> findAllByStatus(IncidentStatus status);

    void canceledIncident(Long idTrip);

    List<IncidentDTO> findIncidentsByCriteria(IncidentCriteriaDTO incidentCriteriaDTO);

    void save(IncidentDTO incident, String role_client);

    Object findAllByIncidentId(Long id);

    List<IncidentDTO> findTripsByCriteria(IncidentCriteriaDTO incidentCriteriaDTO);
}
