package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.CompanyDTO;

public class CompanyAddParameterExistException {
    public CompanyDTO companyDTO;

    public CompanyAddParameterExistException(String message, CompanyDTO companyDTO) {
        super(message);
        this.companyDTO = companyDTO;
    }
}
