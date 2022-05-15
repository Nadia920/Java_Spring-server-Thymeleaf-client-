package com.java.Travel.repository;

import com.java.Travel.model.ProblemsEntity;
import com.java.Travel.model.QuestionsEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Long> {
    Optional<QuestionsEntity> findById(Long id);


    List<QuestionsEntity> findAll();


    void delete(QuestionsEntity questionsEntity);

    void deleteById(Long id);
}
