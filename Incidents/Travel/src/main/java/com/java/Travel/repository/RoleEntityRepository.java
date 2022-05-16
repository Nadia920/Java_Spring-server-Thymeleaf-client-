package com.java.Travel.repository;



import com.java.Travel.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRole(String role);

    List<RoleEntity> findAll();

    Optional<RoleEntity> findById(Long id);

    void delete(RoleEntity roleEntity);

    void deleteById(Long id);


}
