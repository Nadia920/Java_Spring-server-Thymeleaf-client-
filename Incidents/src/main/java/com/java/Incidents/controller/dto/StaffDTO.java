package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Company;
import com.java.Incidents.model.Detachment;

import javax.validation.constraints.NotNull;

public class StaffDTO {
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private String patronymic;
    @NotNull
    private String qualification;
    @NotNull
    private String experience;
    @NotNull
    private String role;
    @NotNull
    private Company company;
    @NotNull
    private Detachment detachment;
    StaffDTO() {}
    StaffDTO(String lastName, String firstName, String patronymic, String qualification, String experience, String role, Company company, Detachment detachment){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.qualification = qualification;
        this.experience = experience;
        this.role = role;
        this.company = company;
        this.detachment = detachment;



    }

}
