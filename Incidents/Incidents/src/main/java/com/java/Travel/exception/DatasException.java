package com.java.Travel.exception;

import com.java.Travel.controller.dto.CityDTO;


public class DatasException extends RuntimeException {

    CityDTO cityDTODepart;
    CityDTO cityDTOArriv;
    String departureDate;

    public DatasException(String msg, CityDTO cityDTODepart, CityDTO cityDTOArriv, String departureDate) {
        super(msg);
        this.cityDTODepart = cityDTODepart;
        this.cityDTOArriv = cityDTOArriv;
        this.departureDate = departureDate;
    }
}
