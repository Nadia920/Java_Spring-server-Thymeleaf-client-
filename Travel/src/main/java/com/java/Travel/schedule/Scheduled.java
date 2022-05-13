package com.java.Travel.schedule;


import com.java.Travel.model.IncidentStatus;
import com.java.Travel.model.IncidentsEntity;
import com.java.Travel.repository.IncidentEntityRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class Scheduled {

    /*
    private final IncidentEntityRepository incidentRepository;

    public Scheduled(IncidentEntityRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    /**
     * Update every 5 minutes

    @Transactional
    @org.springframework.scheduling.annotation.Scheduled(fixedDelay = 300000)
    public void setTripStatusFinished() {
        List<IncidentsEntity> incidentEntityList = incidentRepository.findAllByStatusActiveAndArrivalDateBefore(new Date());

        if (incidentEntityList.size() != 0) {
            incidentEntityList.forEach(a -> incidentRepository.setStatusFinishedWhereTripId(a.getId()));
            incidentEntityList.forEach(a->a.setStatus(String.valueOf(IncidentStatus.FINISHED)));
        }

    }*/

}
