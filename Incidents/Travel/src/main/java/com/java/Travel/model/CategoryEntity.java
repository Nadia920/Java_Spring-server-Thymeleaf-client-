package com.java.Travel.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
@Getter
@Setter
@Table(name = "category")
@NoArgsConstructor
public class CategoryEntity extends BaseEntity {
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<IncidentsEntity> incidents;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<IncidentLog> incidentsLog;

    @NotNull
    @Column(name = "category_name", length = 15)
    String CategoryName;
    @NotNull
    @Column(name = "description_category", length = 15)
    String DescriptionCategory;
  
    
     public Set<IncidentsEntity> addIncident(IncidentsEntity obj) {
        this.incidents.add(obj);
        return this.incidents;
    }
}
