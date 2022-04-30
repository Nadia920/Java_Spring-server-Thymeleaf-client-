package com.java.Incidents.service.servicesInterface;

import com.java.Incidents.controller.dto.CityDTO;


import java.util.List;

public interface CityService {
    CityDTO findOne(Long id);

    void delete(Long id);

    Long getCityIdByName(String name);

    void saveOrUpdate(CityDTO cityDTO, String cuntryName);

    List<CityDTO> getCityListByCountry(Long id);

    Long getCountryIdByCityId(Long id);
}

