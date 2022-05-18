package com.java.Travel.repository;

import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.model.EmployeeEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query(value = "select e.lastName, e.firstName, e.patronymic, e.qualification, e.experience from EmployeeEntity e where e.detachment= ?1")
    List<EmployeeDTO> getEmployeesWithOutDetachment(String detachment);
}
