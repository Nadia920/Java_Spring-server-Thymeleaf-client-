package com.java.Incidents.controller.dto;


import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.City;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class CompanyDTO {
    private Long id;


    private String name;

    private String address;

    private String activityOfTheCompany;

    private CityDTO cityDTO;

    public CompanyDTO() {}

    CompanyDTO(Long id, String name, String address, String activityOfTheCompany, CityDTO cityDTO) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.activityOfTheCompany = activityOfTheCompany;
        this.cityDTO = new CityDTO(id);
    }


    public CompanyDTO(String name, String address, String activityOfTheCompany, CityDTO cityDTO) {
        this.name = name;
        this.address = address;
        this.activityOfTheCompany = activityOfTheCompany;
        this.cityDTO = new CityDTO(id);
    }

    public CompanyDTO(Long id, String name, String address, String activityOfTheCompany) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.activityOfTheCompany = activityOfTheCompany;
    }


    public CompanyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public List<IncidentDTO> getIncidentDTOList() {
        return null;
    }
}
