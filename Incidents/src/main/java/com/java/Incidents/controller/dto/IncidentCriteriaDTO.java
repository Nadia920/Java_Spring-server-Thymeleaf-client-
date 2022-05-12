package com.java.Incidents.controller.dto;


import com.java.Incidents.model.AppRating;
import com.java.Incidents.model.IncidentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentCriteriaDTO {

    private Long idCityDeparture;
    private String departureDate;
    private Integer countSeats;
    private Long idCompany;
    private AppRating ratingCompany;
    private Double minPrice;
    private Double maxPrice;
    private IncidentStatus status;

    public IncidentCriteriaDTO() {
    }

    public IncidentCriteriaDTO(Long idCityDeparture, String departureDate, Integer countSeats, Long idCompany, AppRating ratingCompany, Double minPrice, Double maxPrice, IncidentStatus status) {
        this.idCityDeparture = idCityDeparture;
        this.departureDate = departureDate;
        this.countSeats = countSeats;
        this.idCompany = idCompany;
        this.ratingCompany = ratingCompany;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.status = status;
    }


    @Override
    public String toString() {
        return "TripCriteriaDTO{" +
                "idCityDeparture=" + idCityDeparture +
                ", departureDate='" + departureDate + '\'' +
                ", countSeats=" + countSeats +
                ", idCompany=" + idCompany +
                ", ratingCompany=" + ratingCompany +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", status=" + status +
                '}';
    }

    public Long getIdCity() {

        return null;
    }

    public Long getIdCityArrival() {
        return null;
    }
}

