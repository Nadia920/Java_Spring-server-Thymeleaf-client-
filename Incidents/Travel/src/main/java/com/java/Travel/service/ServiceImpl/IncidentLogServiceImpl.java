/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Travel.service.ServiceImpl;

import com.java.Travel.model.IncidentLog;
import com.java.Travel.repository.IncidentLogRepository;
import com.java.Travel.service.IncidentLogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(IncidentLog incidentLog) {
        IncidentLog obj = incidentLogRepository.save(incidentLog);
    }
    
}
