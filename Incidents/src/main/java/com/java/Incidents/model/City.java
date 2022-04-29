package com.java.Incidents.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class City {
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cityEntity")
    Set<ReceivingCompany> receivingCompany;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cityEntity")
    Set<GivingCompany> givingCompany;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;
}
