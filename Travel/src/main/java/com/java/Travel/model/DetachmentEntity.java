package com.java.Travel.model;


import com.java.Travel.controller.dto.DetachmentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
@Getter
@Setter
@Table(name = "detachments")
@NoArgsConstructor
public class DetachmentEntity extends BaseEntity {

    @Column(name = "detachment_name", length = 15)
    private String detachmentName;
    @NotNull
    @Column(name = "specialization", length = 15)
    private String specialization;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "detachmentEntity")
    public Set<EmployeeEntity> employees;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "detachmentEntity")
    public Set<ProblemsEntity> problems;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "detachmentEntity")
    public Set<FixedDetachmentsEntity> fixedDetachments;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE , mappedBy = "detachmentEntity")
    public Set<IncidentsEntity> incidents;

    public DetachmentEntity(DetachmentDTO detachmentDTO) {
        this.employees = (Set<EmployeeEntity>) detachmentDTO;
    }
}

