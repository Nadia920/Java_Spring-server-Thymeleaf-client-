package com.java.Incidents.controller.dto;

import com.java.Incidents.model.Detachment;
import com.java.Incidents.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
public class ProblemDTO {
    @NotNull
    private String ProblemName;
    @NotNull
    private String DescriptionProblem;
    @NotNull
    private String Solution;
    @NotNull
    private BigInteger idClientP;
    @NotNull
    private BigInteger idDetachmentP;
    @NotNull
    private Detachment detachment;
    @NotNull
    private User user;

    ProblemDTO() {}

    ProblemDTO(String ProblemName, String DescriptionProblem, String Solution, BigInteger IDClientP, BigInteger IDDetachmentP, Detachment detachment, User user) {
        this.ProblemName = ProblemName;
        this.DescriptionProblem = DescriptionProblem;
        this.Solution = Solution;
        this.idClientP = IDClientP;
        this.idDetachmentP = IDDetachmentP;
        this.detachment = detachment;
        this.user = user;



    }

}
