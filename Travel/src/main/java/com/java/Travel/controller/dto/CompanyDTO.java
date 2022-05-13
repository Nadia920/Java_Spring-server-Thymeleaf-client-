package com.java.Travel.controller.dto;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
public class CompanyDTO {

    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    private String name;


    public CompanyDTO(){}

    public CompanyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public CompanyDTO(String name) {
        this.name = name;
    }

    public CompanyDTO(Object id, Object name) {

    }



    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCompanyAddress(String companyAddress) {
    }

    public void setCompanyActivity(String companyActivity) {
    }
}