package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
public class CountryEntity extends BaseEntity {

    @Column(name = "country_name", length = 40)
    private String countryName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "countryEntity")
    Set<CityEntity> cities;



}
