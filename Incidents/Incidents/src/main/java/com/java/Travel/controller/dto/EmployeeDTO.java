package com.java.Travel.controller.dto;

import com.java.Travel.model.CompanyEntity;
import com.java.Travel.model.DetachmentEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeDTO {

        private  Long id;
        @NotNull
        private String lastNameEmployee;
        @NotNull
        private String firstNameEmployee;
        @NotNull
        private String patronymicEmployee;
        @NotNull
        private String qualification;
        @NotNull
        private String experience;
        @NotNull
        private String detachmentTeam;
        @NotNull
        private CompanyEntity company;
        @NotNull
        private DetachmentEntity detachment;
        EmployeeDTO() {}
        EmployeeDTO(String lastName, String firstName, String patronymic, String qualification, String experience, String detachmentTeam, CompanyEntity company, DetachmentEntity detachment){
            this.lastNameEmployee = lastName;
            this.firstNameEmployee = firstName;
            this.patronymicEmployee = patronymic;
            this.qualification = qualification;
            this.experience = experience;
            this.detachmentTeam = detachmentTeam;
            this.company = company;
            this.detachment = detachment;

        }
    public EmployeeDTO(Long id, String lastName, String firstName, String patronymic, String qualification, String experience, CompanyEntity company){
        this.id = id;
        this.lastNameEmployee = lastName;
        this.firstNameEmployee = firstName;
        this.patronymicEmployee = patronymic;
        this.qualification = qualification;
        this.experience = experience;
        this.company = company;
    }



    public EmployeeDTO(Long id, String lastNameEmployee, String firstNameEmployee, String patronymicEmployee, String qualification, String experience, String detachmentTeam, CompanyEntity company, DetachmentEntity detachment) {
    }


}
