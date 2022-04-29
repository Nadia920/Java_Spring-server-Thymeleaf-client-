package com.java.Incidents.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
public class Tests extends BaseEntity {
    @OneToMany(mappedBy = "tests", fetch = FetchType.LAZY)
    private Set<Results> results;

    @NotNull
    @Column(name = "Topic", length = 15)
    String Topic;
    @NotNull
    @Column(name = "Questions", length = 15)
    String Questions;
    @NotNull
    @Column(name = "Answers", length = 15)
    String Answers;
    @NotNull
    @Column(name = "CorrectAnswers", length = 15)
    String CorrectAnswers;
}
