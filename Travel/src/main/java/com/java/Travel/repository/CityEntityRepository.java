package com.java.Travel.repository;


import com.java.Travel.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
@Repository
public interface CityEntityRepository extends JpaRepository<CityEntity, Long> {

    void deleteById(Long id);


    List<CityEntity> findAllByCountryEntity_Id(Long id);

    @Query(value = "select ct.countryEntity.id from CityEntity ct where ct.id=?1")
    Long getIdCountryByCityId(Long id);

}
