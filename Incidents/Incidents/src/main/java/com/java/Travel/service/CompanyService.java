package com.java.Travel.service;

import com.java.Travel.controller.dto.CompanyDTO;
import com.java.Travel.model.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyService {

    Page<CompanyEntity> findAll(Pageable pageable);

    void deleteById(Long id);

    CompanyDTO findOne(Long aLong);

    CompanyEntity findById(Long id);

    Long getCompanyIdByName(String name);

    @Transactional
    void update(CompanyDTO companyDTO);

    CompanyDTO findCompanyByName(String company);
    
    CompanyEntity findCompanyByName1(String company);

    List<CompanyDTO> findAll();
    
    List<CompanyEntity> findAll1();

    /*Page<CompanyEntity> findAllByCriteria(PageRequest pageRequest, String name1);*/
    List<CompanyDTO> getCompanyName();

    @Transactional
    void save(CompanyDTO companyDTO);

    @Transactional
    void save(CompanyEntity company);
    
    boolean save1(CompanyEntity company);
    
    

}
