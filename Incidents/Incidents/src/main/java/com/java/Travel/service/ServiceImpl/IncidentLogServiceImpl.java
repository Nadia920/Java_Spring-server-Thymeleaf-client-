/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.Travel.service.ServiceImpl;

import com.java.Travel.model.CategoryEntity;
import com.java.Travel.model.IncidentLog;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.model.UserEntity;
import com.java.Travel.repository.IncidentLogRepository;
import com.java.Travel.service.CategoryService;
import com.java.Travel.service.IncidentLogService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java.Travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author kabak
 */
@Service
public class IncidentLogServiceImpl implements IncidentLogService{
    @Autowired
    IncidentLogRepository incidentLogRepository;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    public IncidentLogServiceImpl(IncidentLogRepository incidentLogRepo) {
        this.incidentLogRepository = incidentLogRepo;
    }

    @Override
    public List<IncidentLog> findALL() {
        return (incidentLogRepository.findAll());
    }


    @Override
    public boolean save(MultiValueMap<String, String> values) {
        /*IncidentLog obj = incidentLogRepository.save(incidentLog);
        if (obj == null) {
            return false;
        } else {
            return true;
        }*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        CategoryEntity obj1 = categoryService.findById(Long.parseLong(values.get("category.id").get(0)));
        UserEntity obj2 = userService.findById(Long.parseLong(values.get("userEntity.id").get(0)));
        IncidentLog obj = new IncidentLog();
        try {
            obj.setDateIncident(format.parse(values.get("dateIncident").get(0)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        obj.setDescriptionIncident((values.get("descriptionIncident").get(0)));
        obj.setUniqueNumber((values.get("uniqueNumber").get(0)));
        obj.setDangerLevel(Long.parseLong(values.get("dangerLevel").get(0)));
        obj.setPriority(Long.parseLong(values.get("priority").get(0)));
        obj.setCategory(obj1);
        obj.setUserEntity(obj2);
        incidentLogRepository.save(obj);
       return true;
    }

    @Override
    public List<IncidentLog> findIncidentName(String name) {
        List<IncidentLog> all = incidentLogRepository.findAll();
        List<IncidentLog> need = new ArrayList<>();

        for (IncidentLog i : all) {
            if (i.getDescriptionIncident().contains(name)) {
                System.out.println(i.getDescriptionIncident());
                System.out.println(name);
                need.add(i);
            }
        }

        return need;
    }
    
}
