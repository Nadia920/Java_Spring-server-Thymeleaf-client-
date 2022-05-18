package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class CityEntity extends BaseEntity {

    @Column(name = "city_name")
    private String cityName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cityEntity")
    Set<CompanyEntity> companyEntity;

    @ManyToOne()
    @JoinColumn(name = "city_country_id")
    private CountryEntity countryEntity;

}
