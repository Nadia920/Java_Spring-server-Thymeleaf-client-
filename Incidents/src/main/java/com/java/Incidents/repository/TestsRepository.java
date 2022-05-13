package com.java.Incidents.repository;

import org.springframework.data.jpa.repository.Query;

public interface TestsRepository {
    @Query(value = "select * from Tests t where t.id=?1 ")
    Long getTestsById(Long id);
}
