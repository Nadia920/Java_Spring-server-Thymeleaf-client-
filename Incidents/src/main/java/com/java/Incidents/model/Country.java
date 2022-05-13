package com.java.Incidents.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Country")
public class Country extends BaseEntity {
    @Column(name = "name", length = 40)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "country")
    Set<City> cities;
}
