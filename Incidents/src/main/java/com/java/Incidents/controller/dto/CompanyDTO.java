package com.java.Incidents.controller.dto;


import com.java.Incidents.model.AppRaiting;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


public class CompanyDTO {
    private Long id;

    @NotNull
    @Size(min = 2,max = 4)
    private  String name;

    @NotNull
    @Size(min = 2 , max = 5)
    private String code;


    private CityDTO cityDTO;

    public CompanyDTO(){

    }
    public CompanyDTO(String name, String code, Long idCity) {
        this.name = name;
        this.code = code;
        this.cityDTO = new CityDTO(idCity);
    }

    public CompanyDTO(Long id, String name, String code) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public CompanyDTO(Long id, String name, String code, CityDTO cityDTO) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cityDTO = cityDTO;
    }
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;

    @NotNull
    private AppRaiting appRaiting;

    public CompanyDTO(){}

    public CompanyDTO(Long id, String name, appRaiting appRaiting) {
        this.id = id;
        this.name = name;
        this.appRaiting = appRaiting;
    }

    public CompanyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CompanyDTO(String name, appRaiting appRaiting) {
        this.name = name;
        this.appRaiting = appRaiting;
    }
    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appRaiting=" + appRaiting +
                '}';
    }

}
