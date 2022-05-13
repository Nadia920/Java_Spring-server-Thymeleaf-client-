package com.java.Incidents.repository;

import org.springframework.data.jpa.repository.Query;

public interface AppRatingRepository {
    @Query(value = "select * from AppRating c where c.id=?1 ")
    Long getAppRatingById(Long id);
}
