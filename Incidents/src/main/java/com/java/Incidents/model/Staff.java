package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Staff extends BaseEntity {

    @NotNull
    @Column(name = "Last_Name", length = 15)
    private String LastName;
    @NotNull
    @Column(name = "First_Name", length = 15)
    private String FirstName;
    @NotNull
    @Column(name = "Patronymic", length = 15)
    private String Patronymic;
    @NotNull
    @Column(name = "Qualification", length = 15)
    private String Qualification;
    @NotNull
    @Column(name = "Experience", length = 15)
    private String Experience;
    @NotNull
    @Column(name = "Role", length = 15)
    private String Role;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "GivingCompany_ID")
    private Company company;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "Detachment_ID")
    private Detachment detachment;

    @Override
    public String toString() {
        // StringBuilder class also uses Builder Design Pattern with implementation of java.lang.Appendable interface
        StringBuilder builder = new StringBuilder();
        builder.append("Информация о сотруднике: ").append(" фамилия: ").append(LastName).append(", имя: ").append(FirstName).append(", отчество: ").append(Patronymic).append(", квалификация: ").append(Qualification).append(", опыт: ").append(Experience).append(", роль: ").append(Role);
        return builder.toString();
    }
}
