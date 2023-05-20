package com.example.eventmanagement.Controllers;

import com.example.eventmanagement.Models.*;
import com.example.eventmanagement.Services.EventService;
import com.example.eventmanagement.Services.OrderService;
import com.example.eventmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @GetMapping("/getorder/{email}")
    @ResponseBody
    public List<Order> getorder(@PathVariable String email){
        Users user=userService.getbymail(email);
        int uid=user.getUserid();
        return orderService.getbyuid(uid);
    }
    @GetMapping("getbyeid/{eid}")
    @ResponseBody
    public List<Order> getbyeid(@PathVariable long eid){
        return orderService.getbyevid(eid);
    }
    @PostMapping("/addOrder")
    @ResponseBody
    public Order add(@RequestBody OrderReq orderReq){
        Users user=userService.getbymail(orderReq.getEmail());
        Events event=orderReq.getEvent();
        Ticket ticket=orderReq.getTicket();
        Order order=new Order();
        order.setEvent(event);
        order.setUser(user);
        order.setTicket(ticket);
        order.setPrice(orderReq.getTotalPrice());
        order.setQuantity(orderReq.getQuantity());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        order.setOrderdate(LocalDateTime.parse(orderReq.getOrderdate(), formatter));
        return orderService.add(order);
   }
}
