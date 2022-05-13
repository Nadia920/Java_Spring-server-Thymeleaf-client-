package com.java.Incidents.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class CityDTO {
    private  Long id;

    @NotNull
    @Size(min = 3,max = 20)
    private  String name;

    private  List<CompanyDTO> CompanyDTOList;

    private  CountryDTO countryDTO;

    public CityDTO(){

    }

    public CityDTO(Long id, String nameCity, Long idCountry, String nameCountry) {
        this.id = id;
        this.name = nameCity;
        this.countryDTO = new CountryDTO(idCountry, nameCountry);
    }

    public CityDTO(Long idCity) {
        this.id = idCity;
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(Long id, String name, CountryDTO countryDTO) {
        this.id = id;
        this.name = name;
        this.countryDTO = countryDTO;
    }



    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", busStationDTOList=" + CompanyDTOList +
                ", countryDTO=" + countryDTO +
                '}';
    }
}
