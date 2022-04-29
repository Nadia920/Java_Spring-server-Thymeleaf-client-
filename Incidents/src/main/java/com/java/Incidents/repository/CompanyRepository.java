package com.java.Incidents.repository;

import com.java.Incidents.model.AppRaiting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyRepository {
    @Query(value = "SELECT bs.id FROM BusStationEntity bs WHERE bs.name = ?1")
    Long findIdByName(String name);

    @Query(value = "SELECT bs.id FROM BusStationEntity bs WHERE bs.code = ?1")
    Long findIdByCode(String code);

    Optional<Company> findById(Long id);

    List<Company> findAll();

    Company findByName(String name);

    Set<Company> findByAppRaiting(AppRaiting AppRaiting);

    Company findByNameAndAppRaiting(String name, AppRaiting AppRaiting);

    void delete(Company Company);

    void deleteById(Long id);

    @Query("SELECT comp.id FROM Company comp WHERE comp.name = ?1")
    Long getCompanyIdByName(String name);

    @Query("select comp from Company comp order by comp.name asc")
    List<Company> findAllAndOrderByName();

    @Query("select company from Company company where LOWER(company.name) like  %?#{[0].toLowerCase()}% ")
    Page<Company> findAllByNameIgnoreCase(String name, Pageable pageable);
}
