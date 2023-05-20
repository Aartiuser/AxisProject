package com.example.eventmanagement.Controllers;

import com.example.eventmanagement.Models.EventReq;
import com.example.eventmanagement.Models.Events;
import com.example.eventmanagement.Models.Users;
import com.example.eventmanagement.Services.EventService;
import com.example.eventmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;
    @GetMapping("/getevents")
    @ResponseBody
    public List<Events> getall(){
        return eventService.getall();
    }
    @GetMapping("/geteventsbyuid/{email}")
    @ResponseBody
    public List<Events> getbyuid(@PathVariable String email){
        Users user=userService.getbymail(email);
        int id=user.getUserid();
        return eventService.getbyuserid(id);
    }
    @GetMapping("/getbydate/{sdate}")
    @ResponseBody
    public List<Events> getbydte(@PathVariable LocalDate sdate){
        return eventService.getbydt(sdate);
    }
    @GetMapping("/getbyloc/{loc}")
    @ResponseBody
    public List<Events> getbyloc(@PathVariable String loc){
        return eventService.getbyloc(loc);
    }
    @GetMapping("/getbytyp/{type}")
    @ResponseBody
    public List<Events> getbytyp(@PathVariable String type){
        return eventService.getbytyp(type);
    }

    @PostMapping("/addevent")
    @ResponseBody
    public Events addEvent(@RequestBody EventReq eventReq){
        Events event=eventReq.getEvents();
        String email=eventReq.getEmail();
        Users user=userService.getbymail(email);
        event.setUser(user);
        return eventService.add(event);
    }
    @PutMapping("/updateevent")
    @ResponseBody
    public Events updateEvent(@RequestBody EventReq eventReq){
        Events event=eventReq.getEvents();
        String email=eventReq.getEmail();
        Users user=userService.getbymail(email);
        event.setUser(user);
        return eventService.add(event);
    }
    @DeleteMapping("/eventdelete")
    @ResponseBody
    public void deleteev(@RequestBody EventReq eventReq){
        Events event=eventReq.getEvents();
        String email=eventReq.getEmail();
        Users user=userService.getbymail(email);
        event.setUser(user);
        eventService.delevent(event);
    }

}
