package com.java.Travel.repository;

import com.java.Travel.model.AppRating;
import com.java.Travel.model.CategoryEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findById(Long id);


    List<CategoryEntity> findAll();


    void delete(CategoryEntity categoryEntity);

    void deleteById(Long id);

}
