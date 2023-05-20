package com.example.eventmanagement.Models;

public class EventReq {
    String email;
    Events events;

    public EventReq(String email, Events events) {
        this.email = email;
        this.events = events;
    }

    public EventReq() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventReq{" +
                "email='" + email + '\'' +
                ", events=" + events +
                '}';
    }
}
