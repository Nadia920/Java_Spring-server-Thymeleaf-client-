package com.java.Travel.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
@Table(name = "questions")
public class QuestionsEntity extends BaseEntity {
    @NotNull
    @Column(name = "question", length = 15)
    String question;
    @NotNull
    @Column(name = "answer", length = 15)
    String answer;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "questions_test_id")
    private TestsEntity testsEntity;
}
