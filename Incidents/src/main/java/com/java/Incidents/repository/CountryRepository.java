package com.java.Incidents.repository;



import com.java.Incidents.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    void deleteById(Long id);

    Optional<Country> findById(Long id);

    @Query(value = "SELECT c.id FROM CountryEntity c WHERE c.name = ?1")
    Long getIdCountryByName(String name);

    Optional<Country> findByName(String name);
}

