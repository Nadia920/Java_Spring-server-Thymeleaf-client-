package com.java.Travel.repository;

import com.java.Travel.model.CategoryEntity;
import com.java.Travel.model.ProblemsEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProblemsRepository extends JpaRepository<ProblemsEntity, Long> {
    Optional<ProblemsEntity> findById(Long id);


    List<ProblemsEntity> findAll();


    void delete(ProblemsEntity problemsEntity);

    void deleteById(Long id);
}
