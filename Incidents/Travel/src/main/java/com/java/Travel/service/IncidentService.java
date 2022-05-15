package com.java.Travel.service;

import com.java.Travel.controller.dto.IncidentCreateUpdateDTO;
import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IncidentService {

    IncidentDTO add(IncidentCreateUpdateDTO incidentDTO);

    IncidentsEntity findById(Long id);

    List<IncidentsEntity> getIncidentsFalse(String name);

    List<IncidentsEntity> getIncidentsTrue(String name);

    List<IncidentDTO> getIncidents();

    List<IncidentDTO> getIncidentsByIncidentName(String name1);

    String getIncidentsReactionByID(Long id);

    List<IncidentsEntity> findALL();

    @Transactional
    void save(IncidentDTO incidentDTO);

    boolean save(IncidentsEntity incidentEntity);
}
