/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.java.Travel.service;

import com.java.Travel.model.IncidentLog;
import java.util.List;

import com.java.Travel.model.IncidentsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author kabak
 */
@Service
public interface  IncidentLogService {
    
      List<IncidentLog> findALL();


      boolean save(MultiValueMap<String, String> values);

      List<IncidentLog> findIncidentName(String name1);
   
}
