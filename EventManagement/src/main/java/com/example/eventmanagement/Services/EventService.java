package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Events;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Events> getall();
    Events add(Events events);
    List<Events> getbyuserid(int id);
    void delevent(Events events);
    Events getbyid(long id);
    List<Events> getbydt(LocalDate sdate);
    List<Events> getbyloc(String loc);
    List<Events> getbytyp(String type);
}
