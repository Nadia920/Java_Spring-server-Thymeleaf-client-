package com.java.Travel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
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
}

