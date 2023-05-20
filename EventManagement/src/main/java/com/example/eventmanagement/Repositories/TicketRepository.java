package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Events;
import com.example.eventmanagement.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    List<Ticket> findAll();
    @Override
    Ticket save(Ticket ticket);

    @Query("select t from Ticket t where t.users.userid = :userId")
    List<Ticket> findByUserId(@Param("userId") Integer userId);
    @Query("select t from Ticket t where t.events.id=:eventId")
    List<Ticket> findByEventId(@Param("eventId")Long eventId);
    @Query("select t from Ticket t where t.events.id=:eventId and t.ticketType.id=:typeId")
    Ticket findByTicketTypeAndEventsId(@Param("eventId") Long evid,@Param("typeId") Integer tid);

    @Query("select t from Ticket t where t.users.userid = :userId and t.events.id=:eventId")
    List<Ticket> findByUsersAndEventsId(@Param("userId") Integer userId,@Param("eventId") Long eventId);
}
