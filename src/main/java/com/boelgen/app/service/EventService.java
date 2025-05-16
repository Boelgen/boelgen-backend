package com.boelgen.app.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boelgen.app.repository.EventRepository;
import com.boelgen.app.model.Event;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;
  public EventService(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }
  
  public List<Event> searchEvents(String query) {
    return eventRepository.searchEvents(query);
  }

  public List<Event> getEventsByDate(Date date) {
    return eventRepository.findByDate(date);
}

public List<Event> getEventsByDescription(String description) {
  return eventRepository.searchEvents(description);
}

public List<Event> getEventsByDescriptionOrAdditionalInfo(String query) {
    return eventRepository.searchEvents(query);
}

}

