package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
public class Results extends BaseEntity {
    @NotNull
    @Column(name = "Topic", length = 15)
    private String Topic;
    @NotNull
    @Column(name = "Test_Result", length = 15)
    private String TestResult;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Tests_R")
    private Tests tests;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Client_R")
    private Client client;
}
