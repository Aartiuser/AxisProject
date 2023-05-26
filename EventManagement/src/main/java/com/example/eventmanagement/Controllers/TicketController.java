package com.example.eventmanagement.Controllers;

import com.example.eventmanagement.Models.*;
import com.example.eventmanagement.Services.EventService;
import com.example.eventmanagement.Services.TicketService;
import com.example.eventmanagement.Services.TicketTypeService;
import com.example.eventmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TicketController {
    @Autowired
    TicketTypeService ticketTypeService;
    @Autowired
    TicketService ticketService;
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;

    @GetMapping("/gettype")
    @ResponseBody
    public List<TicketType> getall(){
        return ticketTypeService.getall();
    }
    @PostMapping("/addtype")
    @ResponseBody
    public TicketType add(@RequestBody TicketType ticketType){
        return ticketTypeService.add(ticketType);
    }

    @GetMapping("/gettypebyid/{id}")
    @ResponseBody
    public TicketType getbyid(@PathVariable int id){
        return ticketTypeService.getbyid(id);
    }
    // Tickets
    @GetMapping("/getticket")
    @ResponseBody
    public List<Ticket> gettic(){
        return ticketService.getall();
    }
    @GetMapping("/getbyevid/{eid}")
    @ResponseBody
    public List<Ticket> getbyevid(@PathVariable long eid){
        return ticketService.findbyeid(eid);
    }
    @GetMapping("/getbyeidtid/{eid}/{tid}")
    @ResponseBody
    public Ticket getbyeidtid(@PathVariable long eid,@PathVariable int tid){
        return ticketService.findbyeidtid(eid,tid);
    }
    @GetMapping("/getbyuid/{email}")
    @ResponseBody
    public List<Ticket> getbyumail(@PathVariable String email){
        Users user=userService.getbymail(email);
        return ticketService.findbyuid(user.getUserid());
    }
    @PostMapping("/addtickets")
    @ResponseBody
    public Ticket addticket(@RequestBody TicketReq ticketReq){
        TicketType ticketType=ticketTypeService.getbyid(ticketReq.getType());
        Events events=eventService.getbyid(ticketReq.getEventid());
        Users users =userService.getbymail(ticketReq.getEmail());
        Ticket ticket=new Ticket();
        ticket.setTicketType(ticketType);
        ticket.setEvents(events);
        ticket.setQuantity(ticketReq.getQuantity());
        ticket.setPrice(ticketReq.getPrice());
        ticket.setEndDate(ticketReq.getEdate());
        ticket.setStartDate(ticketReq.getSdate());
        ticket.setUsers(users);
        return ticketService.add(ticket);
    }
    @DeleteMapping("/delticket/{id}")
    @ResponseBody
    public void ticketdel(@PathVariable long id){
        Ticket ticket=ticketService.findbyid(id);
        ticketService.del(ticket);
    }
}
