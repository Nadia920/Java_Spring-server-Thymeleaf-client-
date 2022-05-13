package com.java.Incidents.controller.dto;

import com.java.Incidents.model.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class DetachmentDTO {

    private Set<FixedDetachments> fixedDetachments;

    private Set<Incidents> incidents;

    private Set<Problems> problems;

    private Set<Staff> staff;

    private Set<Questions> questions;


    String nameDetachment;

    String specialization;

    DetachmentDTO(){}

    DetachmentDTO(String nameDetachment,  String specialization){
        this.nameDetachment = nameDetachment;
        this.specialization = specialization;
    }

}
