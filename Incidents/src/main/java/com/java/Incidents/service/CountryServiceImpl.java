package com.java.Incidents.service;


import com.java.Incidents.controller.dto.CityDTO;
import com.java.Incidents.controller.dto.CountryDTO;
import com.java.Incidents.model.Country;
import com.java.Incidents.repository.CountryRepository;
import com.java.Incidents.service.servicesInterface.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryDTO findOne(Long id) {
        return null;
    }


    /*@Override
    public CountryDTO findOne(Long id) {
        Optional<Country> Country = countryRepository.findById(id);
        return mapToCountryDTO(Country);
    }*/

    @Override
    public Long getCountryIdByName(String name) {
        return null;
    }

    @Override
    public void saveOrUpdate(CountryDTO countryDTO) {

    }

    @Override
    public CountryDTO findCountryByName(String name) {
        return null;
    }

    @Override
    public List<CountryDTO> findAll() {
        return null;
    }

    @Override
    public List<CountryDTO> findAll(Sort name) {
        return null;
    }

    @Override
    public Set<CityDTO> checkCityDTOSet(Set<CityDTO> cityDTOSet) {
        return null;
    }

    /*@Nullable
    private CountryDTO mapToCountryDTO(Optional<Country> Country) {
        if (Country.isPresent()) {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(Country.get().getName());
            countryDTO.setId(Country.get().getId());

            Set<CityDTO> cityDTOSet = Country.get().getCities().stream().map(a -> new CityDTO(a.getId(), a.getName())).collect(Collectors.toSet());
            countryDTO.setCityDTOSet(cityDTOSet);

            return countryDTO;
        } else {
            return null;
        }
    }


    @Override
    public Long getCountryIdByName(String name) {
        return countryRepository.getIdCountryByName(name);
    }

    @Override
    public void saveOrUpdate(CountryDTO countryDTO) {

    }

    @Transactional
    @Override
    public void saveOrUpdate(CountryDTO countryDTO) {
        Country Country = new Country();
        Country.setId(countryDTO.getId());
        Country.setName(countryDTO.getName());

        if (Country.getId() == null) {
            countryRepository.save(Country);
        } else {
            Country editCountry;
            if (countryRepository.findById(Country.getId()).isPresent()) {
                editCountry = countryRepository.findById(Country.getId()).get();
                editCountry.setName(Country.getName());
                countryRepository.save(editCountry);
            } else {
                throw new UserNotFoundException("Country with id=" + Country.getId() + " not found");
            }

        }
    }


    @Override
    public CountryDTO findCountryByName(String name) {
        Optional<Country> Country = countryRepository.findByName(name);
        return mapToCountryDTO(Country);
    }

    @Override
    public List<CountryDTO> findAll() {
        List<Country> countryEntities = countryRepository.findAll(Sort.by("name").ascending());
        return countryEntities.stream().map(a -> new CountryDTO(a.getId(), a.getName())).collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> findAll(Sort name) {
        List<Country> CountryList = countryRepository.findAll(name);

        List<CountryDTO> countryDTOList = new ArrayList<>();
        CountryDTO countryDTO;
        CityDTO cityDTO;
        for (Country Country : CountryList) {
            countryDTO = new CountryDTO(Country.getId(), Country.getName());

            Set<CityDTO> cityDTOSet = new HashSet<>();
            for (CityEntity cityEntity : Country.getCities()) {
                cityDTO = new CityDTO(cityEntity.getId(), cityEntity.getName());

                List<BusStationDTO> busStationDTOList = new ArrayList<>();
                for (BusStationEntity busStationEntity : cityEntity.getBusStations()) {
                    BusStationDTO busStationDTO = new BusStationDTO(busStationEntity.getId(), busStationEntity.getName(), busStationEntity.getCode());
                    busStationDTOList.add(busStationDTO);
                }

                cityDTO.setBusStationDTOList(busStationDTOList);
                cityDTOSet.add(cityDTO);
            }
            countryDTO.setCityDTOSet(cityDTOSet);
            countryDTOList.add(countryDTO);
        }
        return countryDTOList;
    }

    @Override
    public Set<CityDTO> checkCityDTOSet(Set<CityDTO> cityDTOSet) {
        return null;
    }

    @Override
    public Set<CityDTO> checkCityDTOSet(Set<CityDTO> cityDTOSet) {
        return cityDTOSet.size() == 0 || cityDTOSet == null ? null : cityDTOSet;
    }
    */

}

