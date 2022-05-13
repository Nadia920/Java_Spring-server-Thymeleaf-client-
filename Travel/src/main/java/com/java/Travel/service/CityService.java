package com.java.Travel.service;

import com.java.Travel.controller.dto.CategoryDTO;
import com.java.Travel.controller.dto.CityDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CityService {
    CityDTO findOne(Long id);

    void delete(Long id);

   /* Long getCityIdByName(String name);*/

    void saveOrUpdate(CityDTO cityDTO, String cuntryName);

    List<CityDTO> getCityListByCountry(Long id);

    Long getCountryIdByCityId(Long id);

    @Transactional
    void save(CityDTO cityDTO);
}
