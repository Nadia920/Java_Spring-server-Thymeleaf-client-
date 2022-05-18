package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.IncidentCreateUpdateDTO;
import com.java.Travel.controller.dto.IncidentDTO;

import java.util.List;

import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.repository.IncidentEntityRepository;
import com.java.Travel.repository.UserEntityRepository;
import com.java.Travel.service.CategoryService;
import com.java.Travel.service.DetachmentService;
import com.java.Travel.service.IncidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final static Logger LOGGER = LogManager.getLogger();

    @Autowired
    IncidentEntityRepository incidentRepository;

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private DetachmentService detachmentService;

    @Autowired
    private CategoryService categoryService;

    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @Override
    public IncidentDTO add(IncidentCreateUpdateDTO orderDTO) {
        return null;
    }


    @Override
    public IncidentsEntity findById(Long id) {
        return incidentRepository.findById(id).get();
    }


    @Override
    public List<IncidentsEntity> getIncidentsFalse(String name) {

        List<IncidentsEntity> all = incidentRepository.findAll();
        List<IncidentsEntity> need = new ArrayList<>();

        for (IncidentsEntity i : all) {
            if (i.getComments() != null) {
                if (i.getComments().equals(name)) {
                    need.add(i);
                }
            }
        }

        return need;/*need.stream()
                .map(c -> new IncidentDTO(c.getId(), c.getIncidentName(), c.getIncidentSolution(), c.getReaction(), c.getComments(), c.getPreventionMeasures(), c.getStatus(), c.getCategory(), c.getUserEntity(), c.getDetachmentEntity()))
                .collect(Collectors.toList());*/
    }

    @Override
    public List<IncidentsEntity> getIncidentsTrue(String name) {
        List<IncidentsEntity> all = incidentRepository.findAll();
        List<IncidentsEntity> need = new ArrayList<>();

        for (IncidentsEntity i : all) {
            if (i.getComments() != null) {
                if (i.getComments().equals(name)) {
                    need.add(i);
                }
            }
        }
        return need;
    }

    @Override
    public List<IncidentDTO> getIncidents() {
        return null;
    }

    @Override
    public List<IncidentsEntity> findIncidentName(String name) {
        List<IncidentsEntity> all = incidentRepository.findAll();
        List<IncidentsEntity> need = new ArrayList<>();

        for (IncidentsEntity i : all) {
            if (i.getIncidentName().contains(name)) {
                need.add(i);
            }
        }

        return need;
    }

    @Override
    public String getIncidentsReactionByID(Long id) {
        String incident = incidentRepository.getIncidentsReactionByID(id);
        return incident;
    }

    @Override
    public List<IncidentsEntity> findALL() {
        return (incidentRepository.findAll());
    }

    @Transactional
    @Override
    public void save(IncidentDTO incidentDTO) {
        IncidentsEntity incidentEntity = new IncidentsEntity(incidentDTO.getIncidentName(), incidentDTO.getIncidentSolution(), incidentDTO.getReaction(), incidentDTO.getComments(), incidentDTO.getPreventionMeasures(), incidentDTO.getType(), incidentDTO.getCategory(), incidentDTO.getUser(), incidentDTO.getDetachment(), incidentDTO.getStatus(), incidentDTO.getUserDTO(), incidentDTO.getIncidentDTO());
        incidentRepository.save(incidentEntity);
    }

    @Override
    public boolean save(IncidentsEntity obj) {
        UserDetails info = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userRepository.findByLogin(info.getUsername());
        obj.setDetachmentEntity(detachmentService.findById(obj.getDetachmentEntity().getId()));
        obj.setCategory(categoryService.findById(obj.getCategory().getId()));
        obj.setUserEntity(user);
        IncidentsEntity a = incidentRepository.save(obj);
        if (a == null) {
            return false;
        } else {
            return true;
        }
    }

    public IncidentServiceImpl(IncidentEntityRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
