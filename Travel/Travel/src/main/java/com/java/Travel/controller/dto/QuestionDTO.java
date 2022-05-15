package com.java.Travel.controller.dto;



import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
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
    private DetachmentEntity detachment;
    @NotNull
    private UserEntity user;
    QuestionDTO(){}
    QuestionDTO(String question, String answer, Long idClientQ, Long idDetachmentQ, DetachmentEntity detachment, UserEntity user ){
        this.question = question;
        this.answer = answer;
        this.idClientQ = idClientQ;
        this.idDetachmentQ = idDetachmentQ;
        this.detachment = detachment;
        this.user = user;

    }
}

