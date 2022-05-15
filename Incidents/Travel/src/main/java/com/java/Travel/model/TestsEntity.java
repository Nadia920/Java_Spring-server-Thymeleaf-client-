package com.java.Travel.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
@Getter
@Setter
@Table(name = "tests")
@NoArgsConstructor
public class TestsEntity extends BaseEntity {

    static Integer number;
    @NotNull
    @Column(name = "topic", length = 15)
    private String topic;
    @OneToMany(mappedBy = "testsEntity")
    private Set<ResultsEntity> resultsEntity;
    @OneToMany(mappedBy = "testsEntity")
    private Set<QuestionsEntity> questionsEntity;


}

