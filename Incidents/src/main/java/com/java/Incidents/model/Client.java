package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Client extends BaseEntity {
    /*@OneToMany(mappedBy = "IDClientQ", fetch = FetchType.LAZY)
    private Set<Questions> questions;
    @OneToMany(mappedBy = "IDClientP", fetch = FetchType.LAZY)
    private Set<Problems> problems;
    @OneToMany(mappedBy = "IDClientI", fetch = FetchType.LAZY)
    private Set<Incident> incident;
    @OneToMany(mappedBy = "ID_Detachment_P", fetch = FetchType.LAZY)
    private Set<Results> results;*/

    @NotNull
    @Column(name = "Last_Name_Client", length = 15)
    String LastNameClient;
    @NotNull
    @Column(name = "First_Name_Client", length = 15)
    String FirstNameClient;
    @NotNull
    @Column(name = "Patronymic_Client", length = 15)
    String PatronymicClient;

    @NotNull
    @Column(name = "NumberPhone", length = 15)
    String NumberPhone;
    @NotNull
    @Column(name = "phone_number", length = 15)
    String YearOfBirth;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    ReceivingCompany receivingCompany;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "IDClientA")
    List<AppRating> appRating;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "IDClientA")
    List<Results> results;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "IDClientA")
    Set<Questions> questions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "IDClientA")
    Set<Problems> problems;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "IDClientA")
    Set<Incidents> incidents;
}
