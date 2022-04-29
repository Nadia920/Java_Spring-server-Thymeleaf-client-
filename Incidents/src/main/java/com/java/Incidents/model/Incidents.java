package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Getter
@Setter
public class Incidents extends BaseEntity {
    @NotNull
    @Column(name = "Incident_Name", length = 15)
    String IncidentName;
    @NotNull
    @Column(name = "Incident_Solution", length = 15)
    String IncidentSolution;
    @NotNull
    @Column(name = "Reaction", length = 15)
    String Reaction;
    @NotNull
    @Column(name = "Comments", length = 15)
    String Comments;
    @NotNull
    @Column(name = "Prevention_Measures", length = 15)
    String PreventionMeasures;
    @NotNull
    @Column(name = "Prevention_Measures", length = 15)
    String type;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Category_I")
    Category category;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Client_I")
    Client client;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Detachment_I")
    Detachment detachment;
}
