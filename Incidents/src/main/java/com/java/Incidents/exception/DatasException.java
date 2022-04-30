package com.java.Incidents.exception;

import com.java.Incidents.controller.dto.CityDTO;

public class DatasException {
    CityDTO cityDTODepart;
    CityDTO cityDTOArriv;
    String departureDate;

    public DatasException(String msg, CityDTO cityDTODepart, CityDTO cityDTOArriv, String departureDate, IncidentCriteriaDTO incidentCriteriaDTO) {
        super(msg);
        this.cityDTODepart = cityDTODepart;
        this.cityDTOArriv = cityDTOArriv;
        this.departureDate = departureDate;
    }
}
