package com.java.Incidents.repository;


import com.java.Incidents.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT c.id FROM User c WHERE c.login = ?1")
    Long getIdUserByLogin(String login);

    @Query(value = "SELECT c.id FROM User c WHERE c.email = ?1")
    Long getIdUserByEmail(String email);

    @Query(value = "SELECT c.id FROM User c WHERE c.phoneNumber = ?1")
    Long getIdUserByPhoneNumber(String phoneNumber);

    List<User> findAllByRoleEntity_Role(String role);

    void deleteById(Long id);

    Optional<User> findById(Long id);

    User findByLogin(String login);


}

