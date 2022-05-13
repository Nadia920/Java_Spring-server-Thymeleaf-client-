package com.java.Travel.repository;


import com.java.Travel.model.IncidentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentEntityRepository extends JpaRepository<IncidentsEntity, Long> {


    @Query(value = "select i.incidentName, i.incidentSolution, i.reaction, i.comments,i.preventionMeasures," +
            "i.status, i.category, i.userEntity, i.detachmentEntity from IncidentsEntity i where i.comments=?1")
    List<IncidentsEntity> getIncidentsFalse(String name);

    @Query(value = "select i.incidentName, i.incidentSolution, i.reaction, i.comments," +
            "i.preventionMeasures,i.status, i.category, i.userEntity, i.detachmentEntity from IncidentsEntity i where i.comments=?1")
    List<IncidentsEntity> getIncidentsTrue(String name);

    @Query(value = "select i.incidentName, i.incidentSolution, i.reaction, " +
            "i.comments,i.preventionMeasures,i.status, i.category, i.userEntity, i.detachmentEntity from IncidentsEntity i")
    List<IncidentsEntity> getIncidentsByIncidentName(String name);

    @Query(value = "select i.reaction from IncidentsEntity i where id=:id")
    String getIncidentsReactionByID(Long id);

    IncidentsEntity findIncidentEntityByIncidentName(String name);
    Boolean save(IncidentsEntity incidentsEntity);

    /*boolean add(IncidentsEntity obj);*/
}
