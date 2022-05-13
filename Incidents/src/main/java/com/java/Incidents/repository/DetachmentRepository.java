package com.java.Incidents.repository;

import com.java.Incidents.model.City;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetachmentRepository {
    void deleteById(Long id);

    @Query(value = "SELECT * FROM Detachment det WHERE d.ID = ?1")
    Long getDetachmentyByID(String name);

    List<City> findAllByDetachmenty_Id(Long id);

}
