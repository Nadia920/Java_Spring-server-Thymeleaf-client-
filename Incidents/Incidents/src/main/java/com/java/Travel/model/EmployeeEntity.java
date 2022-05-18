package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "employees")
@NoArgsConstructor
public class EmployeeEntity extends BaseEntity {

    @NotNull
    @Column(name = "last_name_employee", length = 15)
    private String lastName;
    @NotNull
    @Column(name = "first_name_employee", length = 15)
    private String firstName;
    @NotNull
    @Column(name = "patronymic_employee", length = 15)
    private String patronymic;
    @NotNull
    @Column(name = "qualification", length = 15)
    private String qualification;
    @NotNull
    @Column(name = "experience", length = 15)
    private String experience;
    @NotNull
    @Column(name = "detachment_team", length = 15)
    private String detachment;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "employees_detachment_id")
    private DetachmentEntity detachmentEntity;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "employees_company_id")
    private CompanyEntity companyEntity;

    public EmployeeEntity (String lastName, String firstName, String patronymic, String qualification, String experience, CompanyEntity companyEntity){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.qualification = qualification;
        this.experience = experience;
        this.companyEntity = companyEntity;

    }

    public EmployeeEntity(Long id, String lastNameEmployee, String firstNameEmployee, String patronymicEmployee, String qualification, String experience, CompanyEntity company) {
        super(id);
        this.lastName = lastNameEmployee;
        this.firstName = firstNameEmployee;
        this.patronymic = patronymicEmployee;
        this.qualification = qualification;
        this.experience = experience;
        this.companyEntity = company;

    }

    @Override
    public String toString() {
        // StringBuilder class also uses Builder Design Pattern with implementation of java.lang.Appendable interface
        StringBuilder builder = new StringBuilder();
        builder.append("Информация о сотруднике: ").append(" фамилия: ").append(lastName).append(", имя: ").append(firstName).append(", отчество: ").append(patronymic).append(", квалификация: ").append(qualification).append(", опыт: ").append(experience);
        return builder.toString();
    }
}

