package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.TicketType;
import com.example.eventmanagement.Repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketTypeServiceImp implements TicketTypeService{

    @Autowired
    TicketTypeRepository ticketTypeRepository;
    public List<TicketType> getall(){
        return ticketTypeRepository.findAll();
    }
    public TicketType add(TicketType ticketType){
        return ticketTypeRepository.save(ticketType);
    }

    public TicketType getbyid(int id){
        return ticketTypeRepository.getTicketTypeById(id);
    }
}
