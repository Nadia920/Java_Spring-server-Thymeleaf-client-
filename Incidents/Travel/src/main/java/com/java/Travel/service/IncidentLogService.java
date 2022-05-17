/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.java.Travel.service;

import com.java.Travel.model.IncidentLog;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kabak
 */
@Service
public interface  IncidentLogService {
    
      List<IncidentLog> findALL();
      void save(IncidentLog incidentLog);
   
}
