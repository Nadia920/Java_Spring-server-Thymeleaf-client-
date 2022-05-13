package com.java.Incidents.repository;

import org.springframework.data.jpa.repository.Query;

public interface ResultsRepository {
    @Query(value = "select * from Results r where r.id=?1 ")
    Long getResultsById(Long id);
}
