package com.java.Incidents.service.servicesInterface;


import com.java.Incidents.controller.dto.CompanyDTO;

import com.java.Incidents.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CompanyService {


    Page<Company> findAll(Pageable pageable);

    void deleteById(Long id);


    CompanyDTO findOne(Long aLong);

    Long getCompanyIdByName(String name);


    @Transactional
    void save(CompanyDTO companyDTO);

    @Transactional
    void update(CompanyDTO companyDTO);

    CompanyDTO findCompanyByName(String company);

    List<CompanyDTO> findAll();

    Page<Company> findAllByCriteria(PageRequest pageRequest, String name1);

}

