package com.java.Travel.repository;

import com.java.Travel.model.AppRating;
import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AppRatingRepository extends JpaRepository<AppRating, Long> {

    Optional<AppRating> findById(Long id);


    List<AppRating> findAll();


    void delete(AppRating appRating);

    void deleteById(Long id);


}
