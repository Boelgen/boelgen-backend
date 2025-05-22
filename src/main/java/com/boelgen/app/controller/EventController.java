package com.boelgen.app.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.boelgen.app.model.Event;
import com.boelgen.app.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
  public ResponseEntity<List<Event>> searchEvents(@RequestParam String query) {
    List<Event> events = eventService.searchEvents(query);
    return ResponseEntity.ok(events);  // Returns JSON
  }
  
  @GetMapping("/events/by-date")
  public ResponseEntity<List<Event>> getEventsByDate(@RequestParam Date date) {
      List<Event> events = eventService.getEventsByDate(date);
      return ResponseEntity.ok(events);
  }

  @GetMapping("/events/filter")
  public ResponseEntity<List<Event>> getEvents(@RequestParam(value = "q", required = false) String query) {
      List<Event> events;
      if (query != null) {
          events = eventService.getEventsByDescriptionOrAdditionalInfo(query);
      } else {
          events = eventService.getAllEvents();
      }
      return ResponseEntity.ok(events);
  }

  @PostMapping("/events")
  public ResponseEntity<Event> createEvent(@RequestBody Event event) {
      Event created = eventService.createEvent(event);
      return ResponseEntity.ok(created);
  }

  @PutMapping("/events/{id}")
  public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody Event event) {
      Event updated = eventService.updateEvent(id, event);
      return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/events/{id}")
  public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
      eventService.deleteEvent(id);
      return ResponseEntity.noContent().build();
  }

}
