/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Travel.service.ServiceImpl;

import com.java.Travel.model.IncidentLog;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.repository.IncidentLogRepository;
import com.java.Travel.service.IncidentLogService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kabak
 */
@Service
public class IncidentLogServiceImpl implements IncidentLogService{
    @Autowired
    IncidentLogRepository incidentLogRepository;
    
    @Override
    public List<IncidentLog> findALL() {
        return (incidentLogRepository.findAll());
    }


    @Override
    public boolean save(IncidentLog incidentLog) {
        IncidentLog obj = incidentLogRepository.save(incidentLog);
        if (obj == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<IncidentLog> findIncidentName(String name) {
        List<IncidentLog> all = incidentLogRepository.findAll();
        List<IncidentLog> need = new ArrayList<>();

        for (IncidentLog i : all) {
            if (i.getDescriptionIncident().contains(name)) {
                need.add(i);
            }
        }

        return need;
    }
    
}
