package com.java.Incidents.repository;

import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.model.Incidents;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemsRepository {
    @Query(value = "select i.id from Incidents i where i.IDDetachmentI=?1 and c.IDClientI=?2")
    Long getProblemIdByClientId(Long IDDetachmentP, Long IDClientP);

    List<Incidents> findAllByClientId(Long id);

    List<Incidents> findAllByProblemId(Long id);

    List<Incidents> findAllByClientrIdAndStatus(Long id, IncidentStatus status, Sort sort);

    @Modifying
    @Query("UPDATE Problems p " +
            "SET p.status = com.java.Incidents.model.ProblemStatus.FINISHED " +
            "WHERE i.id=:id")
    void setStatusFinishedWhereProblemId(Long id);
}
