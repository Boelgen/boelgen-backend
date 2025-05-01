package com.boelgen.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.boelgen.app.repository.EventRepository;
import com.boelgen.app.model.Event;

@Service
public class EventService {
  private final EventRepository eventRepository;
  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }
  
}
