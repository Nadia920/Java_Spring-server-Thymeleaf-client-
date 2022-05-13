package com.java.Travel.repository;

import com.java.Travel.model.QuestionsEntity;
import com.java.Travel.model.ResultsEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResultsRepository extends JpaRepository<ResultsEntity, Long> {
    Optional<ResultsEntity> findById(Long id);


    List<ResultsEntity> findAll();


    void delete(ResultsEntity resultsEntity);

    void deleteById(Long id);
}
