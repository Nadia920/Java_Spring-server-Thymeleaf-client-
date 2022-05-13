package com.java.Travel.service;

import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> findAll();
    boolean save(EmployeeDTO employeeDTO);

    void deleteUserById(Long id);

    EmployeeDTO findUserById(Long id);

    void update(EmployeeDTO employeeDTO);

    List<EmployeeEntity> getEmployeesWithOutDetachment();
}
