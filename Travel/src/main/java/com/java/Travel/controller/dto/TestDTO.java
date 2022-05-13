package com.java.Travel.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TestDTO {

        @NotNull
        private String topic;
        @NotNull
        private String questions;
        @NotNull
        private String answers;
        @NotNull
        private String correctAnswers;
        TestDTO() {}
        TestDTO(String topic, String questions, String answers, String correctAnswers ) {
            this.topic = topic;
            this.questions = questions;
            this.answers = answers;
            this.correctAnswers = correctAnswers;
        }

}
