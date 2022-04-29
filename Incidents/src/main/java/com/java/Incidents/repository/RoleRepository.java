package com.java.Incidents.repository;



import com.java.Incidents.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

    List<Role> findAll();


}

