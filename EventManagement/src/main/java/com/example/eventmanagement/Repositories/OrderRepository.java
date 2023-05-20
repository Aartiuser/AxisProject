package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Order;
import com.example.eventmanagement.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Override
    List<Order> findAll();
    @Override
    Order save(Order order);
    @Query("select o from Order o where o.user.userid=:userId")
    List<Order> findByUserId(@Param("userId")Integer userId);
    @Query("select o from Order o where o.event.id=:eventId")
    List<Order> findByEventId(@Param("userId")Long eventId);
}
