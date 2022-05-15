package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.model.EmployeeEntity;
import com.java.Travel.repository.EmployeeRepository;
import com.java.Travel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
    @Override
    public EmployeeDTO findUserById(Long id) {
        return null;
    }

    @Override
    public void update(EmployeeDTO employeefDTO) {

    }

    @Override
    public List<EmployeeEntity> getEmployeesWithOutDetachment() {
        String name = "NO";
        List<EmployeeDTO> employeeEntities = employeeRepository.getEmployeesWithOutDetachment(name);
        return employeeEntities.stream()
                .map(c -> new EmployeeEntity(c.getId(), c.getLastNameEmployee(), c.getFirstNameEmployee(), c.getPatronymicEmployee(), c.getQualification(), c.getExperience(), c.getCompany()))
                .collect(Collectors.toList());
    }
}
