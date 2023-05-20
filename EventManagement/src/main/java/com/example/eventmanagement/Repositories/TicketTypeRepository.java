package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType,Integer> {
    @Override
    List<TicketType> findAll();
    @Override
    TicketType save(TicketType ticketType);

    TicketType getTicketTypeById(int id);
}
