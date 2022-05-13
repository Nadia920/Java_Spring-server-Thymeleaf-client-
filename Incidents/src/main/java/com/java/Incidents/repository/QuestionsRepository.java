package com.java.Incidents.repository;

import org.springframework.data.jpa.repository.Query;

public interface QuestionsRepository {
    @Query(value = "select * from Questions q where q.id=?1 ")
    Long getQuestionById(Long id);
}
