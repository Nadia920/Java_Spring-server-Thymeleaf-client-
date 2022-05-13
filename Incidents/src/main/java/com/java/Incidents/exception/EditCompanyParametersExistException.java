package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.CompanyDTO;

public class EditCompanyParametersExistException extends RuntimeException {

    CompanyDTO companyDTO;

    public EditCompanyParametersExistException(String message, CompanyDTO companyDTO) {
        super(message);
        this.companyDTO = companyDTO;
    }
}
