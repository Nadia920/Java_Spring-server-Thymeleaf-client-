package com.java.Travel.controller.dto;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CompanyDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String companyName;
    private String companyAddress;
    private String companyActivity;
    private CityDTO cityEntity;

    public CompanyDTO(Long id, String companyName, String companyAddress, String companyActivity, CityDTO cityEntity) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyActivity = companyActivity;
        this.cityEntity = cityEntity;
    }

    public CompanyDTO(){}

    public CompanyDTO(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }


    public CompanyDTO(String companyName) {
        this.companyName = companyName;
    }

    public CompanyDTO(Object id, Object companyName) {

    }



    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + companyName + '\'' +
                '}';
    }

    public void setCompanyAddress(String companyAddress) {
    }

    public void setCompanyActivity(String companyActivity) {
    }
}