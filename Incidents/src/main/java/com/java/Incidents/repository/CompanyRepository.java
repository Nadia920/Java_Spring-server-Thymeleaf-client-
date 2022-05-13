package com.java.Incidents.repository;

import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyRepository {

    Optional<Company> findGivById(Long id);

    List<Company> findGivAll();

    Company findGivByName(String name);

    Set<Company> findGivByAppRaiting(AppRating AppRaiting);

    Company findGivByNameAndAppRaiting(String name, AppRating AppRaiting);

    void deleteGiv(Company Company);

    void deleteGivById(Long id);

    @Query("SELECT comp.id FROM Company comp WHERE comp.name = ?1")
    Long getGivCompanyIdByName(String name);

    @Query("select comp from Company comp order by comp.name asc")
    List<Company> findAllGivAndOrderByName();

    @Query("select company from Company company where LOWER(company.name) like  %?#{[0].toLowerCase()}% ")
    Page<Company> findAllGivByNameIgnoreCase(String name, Pageable pageable);

    Optional<Company> findRecById(Long id);

    List<Company> findRecAll();

    Company findRecByName(String name);

    Set<Company> findRecByAppRaiting(AppRating AppRaiting);

    Company findRecByNameAndAppRaiting(String name, AppRating AppRaiting);

    void deleteRec(Company Company);

    void deleteRecById(Long id);

    @Query("SELECT comp.id FROM Company comp WHERE comp.name = ?1")
    Long getRecCompanyIdByName(String name);

    @Query("select comp from Company comp order by comp.name asc")
    List<Company> findAllRecAndOrderByName();

    @Query("select company from Company company where LOWER(company.name) like  %?#{[0].toLowerCase()}% ")
    Page<Company> findAllRecByNameIgnoreCase(String name, Pageable pageable);
}
