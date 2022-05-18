package com.java.Travel.controller.dto;


import com.java.Travel.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class DetachmentDTO {

    private Long id;
    private Set<FixedDetachmentsEntity> fixedDetachments;

    private Set<IncidentsEntity> incidents;

    private Set<ProblemsEntity> problems;

    private Set<EmployeeEntity> employees;


    String detachmentName;

    String specialization;

    public DetachmentDTO(){}

    public DetachmentDTO(String detachmentName, String specialization){
        this.detachmentName = detachmentName;
        this.specialization = specialization;
    }

    public DetachmentDTO(Long id, String detachmentName) {
    }

    @Override
    public String toString() {
        return "DetachmentDTO{" +
                "id=" + id +
                ", name='" + detachmentName + '\'' +
                '}';
    }
}

