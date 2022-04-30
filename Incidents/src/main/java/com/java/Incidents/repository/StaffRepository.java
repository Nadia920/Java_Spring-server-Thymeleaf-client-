package com.java.Incidents.repository;

import com.java.Incidents.model.Country;
import com.java.Incidents.model.Staff;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StaffRepository {
    void deleteById(Long id);

    Optional<Staff> findById(Long id);

    @Query(value = "SELECT * FROM Staff s WHERE s.ID = ?1")
    Long getIdCountryByID(Long ID);

    @Query(value = "SELECT s.id FROM Staff s WHERE s.LastName = ?1")
    Long getIdCountryByLastName(String name);

    Optional<Staff> findByName(String name);
}
