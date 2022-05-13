package com.java.Travel.service.ServiceImpl;

import com.java.Travel.controller.dto.CityDTO;

import java.util.List;

import com.java.Travel.controller.dto.CountryDTO;
import com.java.Travel.exception.UserNotFoundException;
import com.java.Travel.model.CityEntity;
import com.java.Travel.model.CountryEntity;
import com.java.Travel.repository.CityEntityRepository;
import com.java.Travel.repository.CountryEntityRepository;
import com.java.Travel.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityEntityRepository cityRepository;
    @Autowired
    private CountryEntityRepository countryRepository;



    @Override
    public CityDTO findOne(Long id) {
        Optional<CityEntity> cityEntity = cityRepository.findById(id);
        if (cityEntity.isPresent()) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(cityEntity.get().getCityName());
            cityDTO.setId(cityEntity.get().getId());

            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setName(cityEntity.get().getCountryEntity().getCountryName());
            countryDTO.setId(cityEntity.get().getCountryEntity().getId());
            cityDTO.setCountryDTO(countryDTO);

            /*List<CompanyDTO> companyDTOList = cityEntity
                    .get().getCompany().stream()
                    .map(a -> new CompanyDTO(a.getId(), a.getName()))
                    .collect(Collectors.toList());

            cityDTO.setCompanyDTOList(companyDTOList);*/
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

    /*@Override
    public Long getCityIdByName(String name) {
        return cityRepository.getIdExistCityByName(name);
    }*/

    @Transactional
    @Override
    public void saveOrUpdate(CityDTO cityDTO, String countryName) {

        if (cityDTO.getId() == null) {
            CityEntity cityEntity = new CityEntity();
            cityEntity.setId(cityDTO.getId());
            cityEntity.setCityName(cityDTO.getName());

            /*Optional<CountryEntity> countryEntity = countryRepository.findByName(countryName);*/
            Optional<CountryEntity> countryEntity = null;
            cityEntity.setCountryEntity(countryEntity.get());

            cityRepository.save(cityEntity);
        } else {
            CityEntity editCityEntity;
            if (cityRepository.findById(cityDTO.getId()).isPresent()) {
                editCityEntity = cityRepository.findById(cityDTO.getId()).get();
                editCityEntity.setCityName(cityDTO.getName());
                cityRepository.save(editCityEntity);
            } else {
                throw new UserNotFoundException("City with id=" + cityDTO.getId() + " not found");
            }

        }
    }

    @Override
    public List<CityDTO> getCityListByCountry(Long id) {
        List<CityEntity> cityEntities = cityRepository.findAllByCountryEntity_Id(id);
        return cityEntities.stream()
                .map(c -> new CityDTO(c.getId(), c.getCityName(), c.getCountryEntity().getId(), c.getCountryEntity().getCountryName()))
                .collect(Collectors.toList());
    }

    @Override
    public Long getCountryIdByCityId(Long id) {
        return cityRepository.getIdCountryByCityId(id);
    }

    @Override
    public void save(CityDTO cityDTO) {

    }

}
