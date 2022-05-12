package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Tests;
import com.java.Incidents.model.User;

import javax.validation.constraints.NotNull;

public class ResultsDTO {
    @NotNull
    private String topic;
    @NotNull
    private String testResult;
    @NotNull
    private Tests tests;
    @NotNull
    private User user;
    ResultsDTO(){}
    ResultsDTO(String topic, String testResult, Tests tests, User user){
        this.topic = topic;
        this.testResult = testResult;
        this.tests = tests;
        this.user = user;

    }
}
