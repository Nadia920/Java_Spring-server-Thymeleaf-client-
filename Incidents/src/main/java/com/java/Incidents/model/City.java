package com.java.Incidents.model;

import javax.persistence.*;
import java.util.Set;

public class City extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    Set<Company> company;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;
}
