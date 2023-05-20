package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getbyuid(int uid);
    List<Order> getbyevid(long evid);
    Order add(Order order);
}
