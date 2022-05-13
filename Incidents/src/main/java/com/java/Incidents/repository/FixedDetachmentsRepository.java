package com.java.Incidents.repository;

import com.java.Incidents.model.Country;
import com.java.Incidents.model.FixedDetachments;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FixedDetachmentsRepository {
    void deleteById(Long id);

    Optional<Country> findById(Long id);

    @Query(value = "SELECT * FROM FixedDetachments f WHERE f.ID = ?1")
    Long getallFixedDetachmentsById(String name);

    Optional<FixedDetachments> findByName(String name);
}
