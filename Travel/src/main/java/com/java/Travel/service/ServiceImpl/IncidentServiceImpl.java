package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.IncidentCreateUpdateDTO;
import com.java.Travel.controller.dto.IncidentDTO;

import java.util.List;


import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.repository.IncidentEntityRepository;
import com.java.Travel.repository.UserEntityRepository;
import com.java.Travel.service.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService {
    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    IncidentEntityRepository incidentRepository;

    @Autowired
    private UserEntityRepository userRepository;
    @Autowired
    private IncidentEntityRepository incidentEntityRepository;

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");


    @Override
    public IncidentDTO add(IncidentCreateUpdateDTO orderDTO) {
        return null;
    }

    @Override
    public List<IncidentDTO> getOrdersByUserId(Long id) {
        return null;
    }

    @Override
    public IncidentDTO findById(Long id) {
        return null;
    }

    @Override
    public void deleteTicketsOnTripByUSer(IncidentCreateUpdateDTO order) {

    }

    @Override
    public IncidentDTO takeMoreTickets(IncidentCreateUpdateDTO order) {
        return null;
    }

    @Override
    public List<IncidentDTO> findAllByTripId(Long idTrip) {
        return null;
    }

    @Override
    public List<IncidentDTO> getOrdersByUserIdAndStatus(Long id, IncidentStatus status) {
        return null;
    }

    @Override
    public List<IncidentDTO> getIncidentsFalse(String name) {

        List<IncidentsEntity> incidentEntities = incidentRepository.getIncidentsFalse(name);
        return incidentEntities.stream()
                .map(c -> new IncidentDTO(c.getId(), c.getIncidentName(), c.getIncidentSolution(), c.getReaction(), c.getComments(), c.getPreventionMeasures(), c.getStatus(), c.getCategory(), c.getUserEntity(), c.getDetachmentEntity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<IncidentDTO> getIncidentsTrue(String name) {

        List<IncidentsEntity> incidentEntities = incidentRepository.getIncidentsTrue(name);
        return incidentEntities.stream()
                .map(c -> new IncidentDTO(c.getId(), c.getIncidentName(), c.getIncidentSolution(), c.getReaction(), c.getComments(), c.getPreventionMeasures(), c.getStatus(), c.getCategory(), c.getUserEntity(), c.getDetachmentEntity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<IncidentDTO> getIncidents() {
        return null;
    }

    @Override
    public List<IncidentDTO> getIncidentsByIncidentName(String name1) {
        String name = name1;
        List<IncidentsEntity> incidentEntities = incidentRepository.getIncidentsByIncidentName(name);
        return incidentEntities.stream()
                .map(c -> new IncidentDTO(c.getId(), c.getIncidentName(), c.getIncidentSolution(), c.getReaction(), c.getComments(), c.getPreventionMeasures(), c.getStatus(), c.getCategory(), c.getUserEntity(), c.getDetachmentEntity()))
                .collect(Collectors.toList());
    }

    @Override
    public String getIncidentsReactionByID(Long id) {
        String incident = incidentRepository.getIncidentsReactionByID(id);
        return incident;
    }

    @Override
    public List<IncidentDTO> findALL() {
        return null;
    }

    @Transactional
    @Override
    public void save(IncidentDTO incidentDTO) {
        IncidentsEntity incidentEntity = new IncidentsEntity(incidentDTO.getIncidentName(), incidentDTO.getIncidentSolution(), incidentDTO.getReaction(), incidentDTO.getComments(), incidentDTO.getPreventionMeasures(), incidentDTO.getType(), incidentDTO.getCategory(), incidentDTO.getUser(), incidentDTO.getDetachment(), incidentDTO.getStatus(), incidentDTO.getUserDTO(), incidentDTO.getIncidentDTO());
        incidentRepository.save(incidentEntity);
    }


}
