package com.example.eventmanagement.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderReq {
    int quantity;
    BigDecimal price;
    Events event;
    String email;
    Ticket ticket;
   String orderdate;

    public OrderReq() {
    }

    public OrderReq(int quantity, BigDecimal price, Events event, String email, Ticket ticket, String orderdate) {
        this.quantity = quantity;
        this.price = price;
        this.event = event;
        this.email = email;
        this.ticket = ticket;
        this.orderdate = orderdate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.price = totalPrice;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}
