package com.java.Travel.repository;


import com.java.Travel.model.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Long> {

    Optional<CompanyEntity> findById(Long id);


    List<CompanyEntity> findAll();

    /*CompanyEntity findByName(String name);*/


    void delete(CompanyEntity companyEntity);

    void deleteById(Long id);

    @Query("SELECT comp.id FROM CompanyEntity comp WHERE comp.companyName = ?1")
    Long getCompanyIdByName(String name);

    //    List<CompanyEntity> findAllAndOrderByName();
//    @Query("select comp.companyName from CompanyEntity comp order by comp.companyName asc")
    List<CompanyEntity> findAllByCompanyName(String name);

    /*@Query("select comp.companyName from CompanyEntity company where LOWER(company.companyName) like  %?#{[0].toLowerCase()}% ")
    Page<CompanyEntity> findAllByNameIgnoreCase(String name, Pageable pageable);*/

    @Query("select comp.companyName from CompanyEntity comp")
    List<CompanyEntity> findCompanyName();

}
