package com.java.Travel.service;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.model.EmployeeEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> findAll();


    void deleteUserById(Long id);

    EmployeeDTO findUserById(Long id);

    void update(EmployeeDTO employeeDTO);

    List<EmployeeEntity> getEmployeesWithOutDetachment();

    @Transactional
    void save(EmployeeDTO employeeDTO);
}
