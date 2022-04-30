package com.java.Incidents.repository;

import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.GivingCompany;
import com.java.Incidents.model.ReceivingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyRepository {

    Optional<GivingCompany> findGivById(Long id);

    List<GivingCompany> findGivAll();

    GivingCompany findGivByName(String name);

    Set<GivingCompany> findGivByAppRaiting(AppRating AppRaiting);

    GivingCompany findGivByNameAndAppRaiting(String name, AppRating AppRaiting);

    void deleteGiv(GivingCompany Company);

    void deleteGivById(Long id);

    @Query("SELECT comp.id FROM Company comp WHERE comp.name = ?1")
    Long getGivCompanyIdByName(String name);

    @Query("select comp from Company comp order by comp.name asc")
    List<GivingCompany> findAllGivAndOrderByName();

    @Query("select company from Company company where LOWER(company.name) like  %?#{[0].toLowerCase()}% ")
    Page<GivingCompany> findAllGivByNameIgnoreCase(String name, Pageable pageable);

    Optional<ReceivingCompany> findRecById(Long id);

    List<ReceivingCompany> findRecAll();

    ReceivingCompany findRecByName(String name);

    Set<ReceivingCompany> findRecByAppRaiting(AppRating AppRaiting);

    ReceivingCompany findRecByNameAndAppRaiting(String name, AppRating AppRaiting);

    void deleteRec(ReceivingCompany Company);

    void deleteRecById(Long id);

    @Query("SELECT comp.id FROM Company comp WHERE comp.name = ?1")
    Long getRecCompanyIdByName(String name);

    @Query("select comp from Company comp order by comp.name asc")
    List<ReceivingCompany> findAllRecAndOrderByName();

    @Query("select company from Company company where LOWER(company.name) like  %?#{[0].toLowerCase()}% ")
    Page<ReceivingCompany> findAllRecByNameIgnoreCase(String name, Pageable pageable);
}
