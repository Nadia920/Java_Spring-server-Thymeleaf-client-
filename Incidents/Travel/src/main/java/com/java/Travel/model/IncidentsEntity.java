package com.java.Travel.model;

import com.java.Travel.controller.dto.IncidentDTO;
import com.java.Travel.controller.dto.UserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
@ToString
@Table(name = "incidents")
@NoArgsConstructor
public class IncidentsEntity extends BaseEntity {
    @NotNull
    @Column(name = "incident_name", length = 15)
    private String incidentName;
    @NotNull
    @Column(name = "incident_solution", length = 15)
    private String incidentSolution;
    @NotNull
    @Column(name = "incident_reaction", length = 15)
    private String reaction;
    @NotNull
    @Column(name = "incident_comments", length = 15)
    private String comments;
    @NotNull
    @Column(name = "prevention_measures", length = 15)
    private String preventionMeasures;
    @NotNull
    @Column(name = "status", length = 15)
    private String status;


    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "incidents_category_id")
    private CategoryEntity category;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "incidents_user_id")
    private UserEntity userEntity;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "incidents_detachment_id")
    private DetachmentEntity detachmentEntity;

    public IncidentsEntity(String incidentName, String incidentSolution, String reaction, String comments, String preventionMeasures, String type, CategoryEntity category, UserEntity user, DetachmentEntity detachment, IncidentStatus status, UserDTO userDTO, IncidentDTO incidentDTO) {
    }

    public IncidentsEntity(String incidentName, String comments) {
        this.incidentName = incidentName;
        this.comments = comments;
    }
    
    



}

