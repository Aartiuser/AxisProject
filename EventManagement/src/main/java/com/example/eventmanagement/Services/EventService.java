package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Events;

import java.util.List;

public interface EventService {
    List<Events> getall();
    Events add(Events events);
    List<Events> getbyuserid(int id);
    void delevent(Events events);
    Events getbyid(long id);
}
