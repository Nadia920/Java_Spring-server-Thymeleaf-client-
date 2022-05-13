package com.java.Incidents.controller.dto;

public class IncidentCreateUpdateDTO {
    private Long id;
    private String IncidentName;
    private String IncidentSolution;
    private String Reaction;
    private String Comments;
    private String PreventionMeasures;
    private String type;
    private Long idClient;
    private Long idCategory;
    private Long idDetachment;

    IncidentCreateUpdateDTO(){}

    @Override
    public String toString() {
        return "OrderCreateUpdateDTO{" +
                "id=" + id +
                ", IncidentName=" + IncidentName +
                ", IncidentSolution=" + IncidentSolution +
                ", Reaction=" + Reaction +
                ", Comments=" + Comments +
                ", PreventionMeasures=" + PreventionMeasures +
                ", type=" + type +
                ", idClient=" + idClient +
                ", idClient=" + idCategory +
                ", idClient=" + idDetachment +
                '}';
    }

    public void setIdClient(Long id) {
    }
}
