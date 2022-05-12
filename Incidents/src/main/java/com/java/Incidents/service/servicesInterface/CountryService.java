package com.java.Incidents.service.servicesInterface;



import com.java.Incidents.controller.dto.CityDTO;
import com.java.Incidents.controller.dto.CountryDTO;
import com.java.Incidents.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface CountryService {

    Page<Country> findAll(Pageable pageable);

    void delete(Long id);

    CountryDTO findOne(Long id);

    Long getCountryIdByName(String name);

    void saveOrUpdate(CountryDTO countryDTO);

    CountryDTO findCountryByName(String name);

    List<CountryDTO> findAll();

    List<CountryDTO> findAll(Sort name);

    Set<CityDTO> checkCityDTOSet(Set<CityDTO> cityDTOSet);
}

