/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.java.Travel.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author kabak
 */
@Entity
@Getter
@Setter
@Table(name = "incident_log")
@NoArgsConstructor
public class IncidentLog extends BaseEntity implements Comparable<IncidentLog>{
    @NotNull
    @Column(name = "date_incident", length = 15)
    private Date dateIncident;
    @NotNull
    @Column(name = "description_incident", length = 15)
    private String descriptionIncident;
    @NotNull
    @Column(name = "unique_number", length = 15)
    private String uniqueNumber;
    @NotNull
    @Column(name = "log_incidents_dangerlevel", length = 15)
    private Long dangerLevel;
    @NotNull
    @Column(name = "log_incidents__priority", length = 15)
    private Long priority;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "log_incidents_category_id")
    private CategoryEntity category;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = " log_incidents_user_id")
    private UserEntity userEntity;

    @Override
    public int compareTo(@org.jetbrains.annotations.NotNull IncidentLog o) {
                if(this.priority>o.getPriority()){
                    return -1;
                }
                if(this.priority==o.getPriority()) {
                    return 0;
                }
                else return 1;
    }

    public IncidentLog(String descriptionIncident, Long priority) {
        this.descriptionIncident = descriptionIncident;
        this.priority = priority;
    }
}
