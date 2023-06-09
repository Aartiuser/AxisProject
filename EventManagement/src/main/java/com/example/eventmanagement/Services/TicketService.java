package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getall();
    Ticket findbyeidtid(long eid,int tid);
    List<Ticket> findbyeid(long id);
    Ticket add(Ticket ticket);
    List<Ticket> findbyuid(int uid);
    Ticket findbyid(long id);
    void del(Ticket ticket);
}
