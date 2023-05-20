package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Order;
import com.example.eventmanagement.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    public List<Order> getbyuid(int uid){
        return orderRepository.findByUserId(uid);
    }
    public List<Order> getbyevid(long evid){
        return orderRepository.findByEventId(evid);
    }
    public Order add(Order order){
        return orderRepository.save(order);
    }
}
