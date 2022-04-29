package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class ReceivingCompany extends BaseEntity {
    @OneToMany(mappedBy = "ID_Detachment_P", fetch = FetchType.LAZY)
    private Set<Client> client;
    @OneToMany(mappedBy = "ID_Detachment_P", fetch = FetchType.LAZY)
    private Set<FixedDetachments> fixedDetachments;
    @NotNull
    @Column(name = "Name_Receiving", length = 15)
    String NameReceiving;
    @NotNull
    @Column(name = "Address_Receiving;", length = 15)
    String AddressReceiving;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private City city;
}
