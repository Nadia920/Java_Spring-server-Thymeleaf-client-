package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Set;
@Getter
@Setter
public class Detachment extends BaseEntity {

    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<FixedDetachments> fixedDetachments;
    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<Incidents> incidents;
    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<Problems> problems;
    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<Staff> staff;
    @OneToMany(mappedBy = " ", fetch = FetchType.LAZY)
    private Set<Questions> questions;

    @Column(name = "Name_Detachment", length = 15)
    String NameDetachment;
    @NotNull
    @Column(name = "Specialization", length = 15)
    String Specialization;

}
