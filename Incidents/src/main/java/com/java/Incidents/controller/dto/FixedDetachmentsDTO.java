package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Company;
import com.java.Incidents.model.Detachment;

public class FixedDetachmentsDTO {

    private Detachment detachment;

    private Company company;

    FixedDetachmentsDTO() {}

    FixedDetachmentsDTO(Detachment detachment, Company company) {
        this.detachment = detachment;
        this.company = company;
    }
}
