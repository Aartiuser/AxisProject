package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.TicketType;

import java.util.List;

public interface TicketTypeService {
    List<TicketType> getall();
    TicketType add(TicketType ticketType);

    TicketType getbyid(int id);
}
