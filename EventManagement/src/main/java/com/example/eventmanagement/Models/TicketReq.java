package com.example.eventmanagement.Models;

import java.math.BigDecimal;
import java.time.LocalDate;


public class TicketReq {
    int type;
    String email;
    long eventid;
    BigDecimal price;
    int quantity;
    LocalDate sdate;
    LocalDate edate;

    public TicketReq(int type, String email, long eventid, BigDecimal price, int quantity, LocalDate sdate, LocalDate edate) {
        this.type = type;
        this.email = email;
        this.eventid = eventid;
        this.price = price;
        this.quantity = quantity;
        this.sdate = sdate;
        this.edate = edate;
    }

    public TicketReq() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
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

    public LocalDate getSdate() {
        return sdate;
    }

    public void setSdate(LocalDate sdate) {
        this.sdate = sdate;
    }

    public LocalDate getEdate() {
        return edate;
    }

    public void setEdate(LocalDate edate) {
        this.edate = edate;
    }

    @Override
    public String toString() {
        return "TicketReq{" +
                "type=" + type +
                ", email='" + email + '\'' +
                ", eventid=" + eventid +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sdate=" + sdate +
                ", edate=" + edate +
                '}';
    }
}
