package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Detachment;
import com.java.Incidents.model.User;

import javax.validation.constraints.NotNull;

public class QuestionDTO {
    @NotNull
    private String question;
    @NotNull
    private String answer;
    @NotNull
    private Long idClientQ;
    @NotNull
    private Long idDetachmentQ;
    @NotNull
    private Detachment detachment;
    @NotNull
    private User user;
    QuestionDTO(){}
    QuestionDTO(String question, String answer, Long idClientQ, Long idDetachmentQ, Detachment detachment, User user ){
        this.question = question;
        this.answer = answer;
        this.idClientQ = idClientQ;
        this.idDetachmentQ = idDetachmentQ;
        this.detachment = detachment;
        this.user = user;

    }
}
