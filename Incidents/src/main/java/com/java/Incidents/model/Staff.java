package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Getter
@Setter
public class Staff extends BaseEntity {

    @NotNull
    @Column(name = "Last_Name", length = 15)
    String LastName;
    @NotNull
    @Column(name = "First_Name", length = 15)
    String FirstName;
    @NotNull
    @Column(name = "Patronymic", length = 15)
    String Patronymic;
    @NotNull
    @Column(name = "Qualification", length = 15)
    String Qualification;
    @NotNull
    @Column(name = "Experience", length = 15)
    String Experience;
    @NotNull
    @Column(name = "Role", length = 15)
    String Role;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "GivingCompany_ID")
    GivingCompany givingCompany;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "Detachment_ID")
    Detachment detachment;
}
