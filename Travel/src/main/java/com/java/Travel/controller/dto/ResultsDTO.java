package com.java.Travel.controller.dto;


import com.java.Travel.model.TestsEntity;
import com.java.Travel.model.UserEntity;

import javax.validation.constraints.NotNull;

public class ResultsDTO {
    @NotNull
    private String topic;
    @NotNull
    private String testResult;
    @NotNull
    private TestsEntity tests;
    @NotNull
    private UserEntity user;
    ResultsDTO(){}
    ResultsDTO(String topic, String testResult, TestsEntity tests, UserEntity user){
        this.topic = topic;
        this.testResult = testResult;
        this.tests = tests;
        this.user = user;

    }
}

