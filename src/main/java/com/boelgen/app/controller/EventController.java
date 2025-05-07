package com.boelgen.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.boelgen.app.model.Event;
import com.boelgen.app.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EventController {

  public final EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);  // Returns JSON
    }

  @GetMapping("/events/search")
  public ResponseEntity<List<Event>> searchEvents(@RequestParam String query, @RequestParam String additionalParamString) {
    List<Event> events = eventService.searchEvents(query, additionalParamString);
    return ResponseEntity.ok(events);  // Returns JSON
  }
  
}
