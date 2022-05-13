package com.java.Travel.repository;

import com.java.Travel.model.TestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TestsRepository extends JpaRepository<TestsEntity, Long> {
    Optional<TestsEntity> findById(Long id);


    List<TestsEntity> findAll();


    void delete(TestsEntity resultsEntity);

    void deleteById(Long id);

}
