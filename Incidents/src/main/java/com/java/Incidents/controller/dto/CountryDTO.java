package com.java.Incidents.controller.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class CountryDTO {
    private  Long id;

    @NotNull
    @Size(min = 3,max = 40)
    private  String name;

    private Set<CityDTO> cityDTOSet;

    public CountryDTO(){

    }

    public CountryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
