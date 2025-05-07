package com.boelgen.app.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boelgen.app.model.Event;
import com.boelgen.app.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/events/by-date")
    public ResponseEntity<List<Event>> getEventsByDate(@RequestParam Date date) {
        List<Event> events = eventService.getEventsByDate(date);
        return ResponseEntity.ok(events);
    }
}
