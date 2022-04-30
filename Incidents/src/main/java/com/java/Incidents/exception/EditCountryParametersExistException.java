package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.CountryDTO;


public class EditCountryParametersExistException extends RuntimeException {

    CountryDTO countryDTO;

    public EditCountryParametersExistException(String message, CountryDTO countryDTO) {
        super(message);
        this.countryDTO = countryDTO;
    }

}
