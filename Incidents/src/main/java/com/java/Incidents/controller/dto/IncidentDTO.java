package com.java.Incidents.controller.dto;



import com.java.Incidents.model.Category;
import com.java.Incidents.model.Detachment;
import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.model.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class IncidentDTO {

    private Long id;
    private String IncidentName;
    private String IncidentSolution;
    private String Reaction;
    private String Comments;
    private String PreventionMeasures;
    private String type;
    private Category category;
    private User user;
    private Detachment detachment;
    private IncidentStatus status;
    private UserDTO userDTO;
    private IncidentDTO incidentDTO;


    public IncidentDTO() {
    }

    public IncidentDTO(Long id, Double finalCost, IncidentStatus status, Timestamp orderDate, UserDTO userDTO, IncidentDTO incidentDTO) {
        this.id = id;
        this.status = status;
        this.userDTO = userDTO;
        this.incidentDTO = incidentDTO;

    }

    public IncidentDTO(Long id) {
        this.id = id;
    }


    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IncidentDTO{" +
                "id=" + id +
                ", IncidentName=" + IncidentName +
                ", IncidentSolution=" + IncidentSolution +
                ", Reaction=" + Reaction +
                ", Comments" + Comments +
                ", PreventionMeasures=" + PreventionMeasures +
                ", type=" + type +
                ", category=" + category +
                ", user=" + user +
                ", detachment=" + detachment +
                ", status=" + status +
                ", userDTO=" + userDTO +
                ", incidentDTO=" + incidentDTO +
                '}';
    }
}
