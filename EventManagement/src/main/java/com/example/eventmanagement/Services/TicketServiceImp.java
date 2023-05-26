package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Ticket;
import com.example.eventmanagement.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    public List<Ticket> getall(){
        return ticketRepository.findAll();
    }
    public Ticket findbyeidtid(long eid,int tid){
        return ticketRepository.findByTicketTypeAndEventsId(eid,tid);
    }
    public List<Ticket> findbyeid(long id){
        return ticketRepository.findByEventId(id);
    }
    public Ticket add(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> findbyuid(int uid){
        return ticketRepository.findByUserId(uid);

    }
    public Ticket findbyid(long id){
        return ticketRepository.findById(id);
    }
    public void del(Ticket ticket){
        ticketRepository.delete(ticket);
    }
}
