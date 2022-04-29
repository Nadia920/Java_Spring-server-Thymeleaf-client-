package com.java.Incidents.repository;


import com.java.Travel.model.Order;
import com.java.Travel.model.OrderStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select o.id from Order o where o.trip.id=?1 and o.user.id=?2")
    Long getOrderIdByTripIdAndUserId(Long idTrip, Long idUser);

    List<Order> findAllByUserId(Long id);

    List<Order> findAllByTripId(Long id);

    List<Order> findAllByUserIdAndStatus(Long id, OrderStatus status, Sort sort);

    @Modifying
    @Query("UPDATE Order o " +
            "SET o.status = com.java.Travel.model.OrderStatus.FINISHED " +
            "WHERE o.trip.id=:id")
    void setStatusFinishedWhereTripId(Long id);
}
