package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Getter
@Setter
public class AppRating extends BaseEntity {

    @NotNull
    @Column(name = "Value", length = 15)
    private Number Value;
    @NotNull
    @Column(name = "FinalValue", length = 15)
    private Number FinalValue;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Client_A")
    private BigInteger IDClientA;
}
