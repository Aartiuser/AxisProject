package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Events;
import com.example.eventmanagement.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventServiceImp implements EventService{
    @Autowired
    EventRepository eventRepository;
    @Override
    public List<Events> getall(){
        return eventRepository.findAll();
    }
    @Override
    public Events add(Events events){
        return eventRepository.save(events);
    }
    @Override
    public List<Events> getbyuserid(int id){
        return eventRepository.findByUserId(id);
    }
    @Override
    public void delevent(Events events){
        eventRepository.delete(events);
    }
    @Override
    public Events getbyid(long id){
        return eventRepository.findById(id);
    }
    @Override
    public List<Events> getbydt(LocalDate sdate){
        return eventRepository.findBySdate(sdate);
    }
    @Override
    public List<Events> getbyloc(String loc){
        return eventRepository.findByLocation(loc);
    }
    @Override
    public List<Events> getbytyp(String type){
        return eventRepository.findByName(type);
    }

}
