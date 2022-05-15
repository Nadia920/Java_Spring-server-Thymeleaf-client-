package com.java.Travel.model;

import com.java.Travel.controller.dto.ProblemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
@Entity
@Getter
@Setter
@Table(name = "problems")
@NoArgsConstructor
public class ProblemsEntity extends BaseEntity {
    @NotNull
    @Column(name = "problem_name", length = 15)
    String problemName;
    @NotNull
    @Column(name = "description_problem", length = 15)
    String descriptionProblem;
    @NotNull
    @Column(name = "solution_problem", length = 15)
    String solutionProblem;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "problems_user_id")
    private UserEntity userEntity;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "problems_detachment_id")
    private DetachmentEntity detachmentEntity;

    public ProblemsEntity(ProblemDTO problemDTO) {
        this.problemName = problemDTO.getProblemName();
        this.descriptionProblem = problemDTO.getDescriptionProblem();
        this.solutionProblem = "";
        /*this.userEntity = String(getUserEntity().getLastNameUser()) + "" + String(getUserEntity().getFirstNameUser()) + "" + String(getUserEntity().getPatronymicUser());*/
        this.detachmentEntity = problemDTO.getDetachment();

    }

    @Override
    public String toString() {
        return "ProblemsEntity{" + "problemName=" + problemName + ", descriptionProblem=" + descriptionProblem + ", solutionProblem=" + solutionProblem + ", userEntity=" + userEntity + ", detachmentEntity=" + detachmentEntity + '}';
    }
    
    
    
}
