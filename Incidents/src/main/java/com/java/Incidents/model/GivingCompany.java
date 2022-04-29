package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
public class GivingCompany extends BaseEntity {


    @OneToMany(mappedBy = "", fetch = FetchType.LAZY)
    private Set<Staff> staff;

    private String NameGiving;


    @NotNull
    @Column(name = "Address_Giving", length = 15)
    private String AddressGiving;

    @NotNull
    @Column(name = "Activity_Of_the_company", length = 15)
    private String ActivityOfTheCompany;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private City city;
}


