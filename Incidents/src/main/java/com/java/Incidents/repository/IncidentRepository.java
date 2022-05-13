package com.java.Incidents.repository;

import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.model.Incidents;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentRepository {
    @Query(value = "select i.id from Incidents i where i.IDDetachmentI=?1 and c.IDClientI=?2")
    Long getOrderIdByTripIdAndUserId(Long idTrip, Long idUser);

    List<Incidents> findAllByUserId(Long id);

    List<Incidents> findAllByTripId(Long id);

    List<Incidents> findAllByUserIdAndStatus(Long id, IncidentStatus status, Sort sort);

    @Modifying
    @Query("UPDATE Incidents i " +
            "SET i.status = com.java.Incidents.model.IncidentStatus.FINISHED " +
            "WHERE i.id=:id")
    void setStatusFinishedWhereIncidentId(Long id);
}
