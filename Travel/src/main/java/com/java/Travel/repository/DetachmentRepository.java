package com.java.Travel.repository;

import com.java.Travel.controller.dto.DetachmentDTO;
import com.java.Travel.controller.dto.EmployeeDTO;
import com.java.Travel.model.DetachmentEntity;
import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetachmentRepository extends JpaRepository<DetachmentEntity, Long> {
    @Query(value = "select d.detachmentName from DetachmentEntity d ")
    List<DetachmentEntity> getDetachmentName();

    @Query(value = "select d.detachmentName from DetachmentEntity d ")
    List<DetachmentEntity> findByName();

     public DetachmentEntity findByDetachmentName(String name);

    public DetachmentEntity findDetachmentEntityByDetachmentName(String name);
}
