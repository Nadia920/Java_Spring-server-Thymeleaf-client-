package com.java.Travel.controller.dto;


import com.java.Travel.model.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class DetachmentDTO {

    private Set<FixedDetachmentsEntity> fixedDetachments;

    private Set<IncidentsEntity> incidents;

    private Set<ProblemsEntity> problems;

    private Set<EmployeeEntity> employees;

    private Set<QuestionsEntity> questions;


    String nameDetachment;

    String specialization;

    public DetachmentDTO(){}

    public DetachmentDTO(String nameDetachment, String specialization){
        this.nameDetachment = nameDetachment;
        this.specialization = specialization;
    }

    public DetachmentDTO(Long id, String detachmentName) {
    }
}

