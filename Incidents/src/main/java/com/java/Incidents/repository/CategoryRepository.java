package com.java.Incidents.repository;

import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository {
    @Query(value = "select * from Category c where c.id=?1 ")
    Long getCategoryById(Long id);
}
