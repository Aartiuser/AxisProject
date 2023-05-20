package com.example.eventmanagement.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderid;

    BigDecimal price;
    private int quantity;
    private LocalDateTime orderdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventid")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Events event;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketid")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Ticket ticket;

    public Order() {
    }

    public Order(int orderid, BigDecimal price, int quantity, LocalDateTime orderdate, Users user, Events event, Ticket ticket) {
        this.orderid = orderid;
        this.price = price;
        this.quantity = quantity;
        this.orderdate = orderdate;
        this.user = user;
        this.event = event;
        this.ticket = ticket;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDateTime orderdate) {
        this.orderdate = orderdate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", orderdate=" + orderdate +
                ", user=" + user +
                ", event=" + event +
                ", ticket=" + ticket +
                '}';
    }
}

