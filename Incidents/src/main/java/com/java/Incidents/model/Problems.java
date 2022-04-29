package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Getter
@Setter
public class Problems extends BaseEntity {
    @NotNull
    @Column(name = "Problem_Name", length = 15)
    String ProblemName;
    @NotNull
    @Column(name = "Description_Problem", length = 15)
    String DescriptionProblem;
    @NotNull
    @Column(name = "Solution", length = 15)
    String Solution;
    @NotNull
    @Column(name = "ID_Client_P", length = 15)
    BigInteger IDClientP;
    @NotNull
    @Column(name = "ID_Detachment_P", length = 15)
    BigInteger IDDetachmentP;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Detachment detachment;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Client client;
}
