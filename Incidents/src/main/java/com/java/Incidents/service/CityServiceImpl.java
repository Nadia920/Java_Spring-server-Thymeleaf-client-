package com.java.Incidents.service;


import com.java.Incidents.controller.dto.CityDTO;
import com.java.Incidents.repository.CityRepository;
import com.java.Incidents.repository.CountryRepository;
import com.java.Incidents.service.servicesInterface.CityService;
import com.java.Incidents.controller.dto.CompanyDTO;
import com.java.Incidents.controller.dto.CityDTO;

import java.util.List;

import com.java.Incidents.controller.dto.CountryDTO;
import com.java.Incidents.exception.UserNotFoundException;
import com.java.Incidents.model.City;
import com.java.Incidents.model.Country;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Override
    public CityDTO findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long getCityIdByName(String name) {
        return null;
    }

    @Override
    public void saveOrUpdate(CityDTO cityDTO, String cuntryName) {

    }

    @Override
    public List<CityDTO> getCityListByCountry(Long id) {
        return null;
    }

    @Override
    public Long getCountryIdByCityId(Long id) {
        return null;
    }

    /*@Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;



    @Override
    public CityDTO findOne(Long id) {
        Optional<City> cityEntity = cityRepository.findById(id);
        if (cityEntity.isPresent()) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(cityEntity.get().getName());
            cityDTO.setId(cityEntity.get().getId());

            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(cityEntity.get().getCountryEntity().getName());
            countryDTO.setId(cityEntity.get().getCountryEntity().getId());
            cityDTO.setCountryDTO(countryDTO);

            List<BusStationDTO> busStationDTOList = cityEntity
                    .get().getBusStations().stream()
                    .map(a -> new BusStationDTO(a.getId(), a.getName(), a.getCode()))
                    .collect(Collectors.toList());

            cityDTO.setBusStationDTOList(busStationDTOList);
            return cityDTO;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Long getCityIdByName(String name) {
        return cityRepository.getIdExistCityByName(name);
    }

    @Transactional
    @Override
    public void saveOrUpdate(CityDTO cityDTO, String countryName) {

        if (cityDTO.getId() == null) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setId(cityDTO.getId());
            cityEntity.setName(cityDTO.getName());

            Optional<CountryEntity> countryEntity = countryRepository.findByName(countryName);
            cityEntity.setCountryEntity(countryEntity.get());

            cityRepository.save(cityEntity);
        } else {
            CityEntity editCityEntity;
            if (cityRepository.findById(cityDTO.getId()).isPresent()) {
                editCityEntity = cityRepository.findById(cityDTO.getId()).get();
                editCityEntity.setName(cityDTO.getName());
                cityRepository.save(editCityEntity);
            } else {
                throw new UserNotFoundException("City with id=" + cityDTO.getId() + " not found");
            }

        }
    }

    @Override
    public List<CityDTO> getCityListByCountry(Long id) {
        List<City> cityEntities = cityRepository.findAllByCountryEntity_Id(id);
        return cityEntities.stream()
                .map(c -> new CityDTO(c.getId(), c.getName(), c.getCountry().getId(), c.getCountry().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Long getCountryIdByCityId(Long id) {
        return cityRepository.getIdCountryByCityId(id);
    }*/

}
