package com.java.Travel.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
@Table(name = "results")
@NoArgsConstructor
public class ResultsEntity extends BaseEntity {

    @NotNull
    @Column(name = "test_result", length = 15)
    private String testResult;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "results_test_id")
    private TestsEntity testsEntity;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "results_user_id")
    private UserEntity userEntity;
}

