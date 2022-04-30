package com.java.Incidents.repository;


import com.java.Incidents.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    void deleteById(Long id);

    @Query(value = "SELECT c.id FROM City c WHERE c.name = ?1")
    Long getIdExistCityByName(String name);

    List<City> findAllByCountryEntity_Id(Long id);

    @Query(value = "select ct.countryEntity.id from City ct where ct.id=?1")
    Long getIdCountryByCityId(Long id);

}

