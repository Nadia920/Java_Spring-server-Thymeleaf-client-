package com.java.Travel.repository;

import com.java.Travel.model.FixedDetachmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FixedDetachmentsRepository extends JpaRepository<FixedDetachmentsEntity, Long> {
    @Query(value = "select f.detachmentEntity, f.companyEntity from FixedDetachmentsEntity f ")
     List<FixedDetachmentsEntity> getFixedDetachmens();

     boolean safe(FixedDetachmentsEntity obj);
}
