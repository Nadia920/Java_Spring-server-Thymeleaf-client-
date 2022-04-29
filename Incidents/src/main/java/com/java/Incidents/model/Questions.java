package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Getter
@Setter
public class Questions extends BaseEntity {
    @NotNull
    @Column(name = "Question", length = 15)
    String Question;
    @NotNull
    @Column(name = "Answer", length = 15)
    String Answer;
    @NotNull
    @Column(name = "ID_Client_Q", length = 15)
    BigInteger IDClientQ;
    @NotNull
    @Column(name = "ID_Detachment_Q", length = 15)
    BigInteger IDDetachmentQ;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Detachment detachment;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Client client;
}
