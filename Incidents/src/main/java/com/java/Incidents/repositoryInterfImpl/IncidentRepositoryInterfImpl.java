package com.java.Incidents.repositoryInterfImpl;
import com.java.Incidents.model.IncidentStatus;
import com.java.Incidents.model.Incidents;
import com.java.Incidents.repository.*;
import org.springframework.data.domain.Sort;

import java.util.List;

public class IncidentRepositoryInterfImpl extends  AbstractRepository implements IncidentRepository{

    @Override
    public Long getOrderIdByTripIdAndUserId(Long idTrip, Long idUser) {
        return null;
    }

    @Override
    public List<Incidents> findAllByUserId(Long id) {
        return null;
    }

    @Override
    public List<Incidents> findAllByTripId(Long id) {
        return null;
    }

    @Override
    public List<Incidents> findAllByUserIdAndStatus(Long id, IncidentStatus status, Sort sort) {
        return null;
    }

    @Override
    public void setStatusFinishedWhereIncidentId(Long id) {

    }
}
