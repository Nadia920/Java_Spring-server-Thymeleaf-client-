/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.java.Travel.repository;

import com.java.Travel.model.IncidentLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kabak
 */
@Repository
public interface IncidentLogRepository extends JpaRepository<IncidentLog, Long>{

     List<IncidentLog> findAll();


    List<IncidentLog> findByDescriptionIncident();
}
