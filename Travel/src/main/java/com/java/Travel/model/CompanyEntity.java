package com.java.Travel.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
public class CompanyEntity extends BaseEntity {

    @NotNull
    @Column(name = "company_name", length = 30)
    private String companyName;
    @NotNull
    @Column(name = "company_address", length = 30)
    private String companyAddress;
    @NotNull
    @Column(name = "company_activity", length = 30)
    private String companyActivity;

    @ManyToOne()
    @JoinColumn(name = "company_city_id")
    private CityEntity cityEntity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "companyEntity")
    Set<FixedDetachmentsEntity> fixedDetachments;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "companyEntity")
    Set<UserEntity> users;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "companyEntity")
    Set<EmployeeEntity> employee;


    public CompanyEntity(Long id, String name, String address, String activity) {
        super(id);
        this.companyName = name;
        this.companyAddress = address;
        this.companyActivity = activity;
    }

    public CompanyEntity(String name) {
    }

    public CompanyEntity(long l, String fake1) {
    }


    public String getCode() {
        return null;
    }
}
