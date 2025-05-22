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

  public Event createEvent(Event event) {
    return eventRepository.save(event);
  }

  public Event updateEvent(Integer id, Event updatedEvent) {
    Event event = eventRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Event not found"));
    // Update fields
    event.setDate(updatedEvent.getDate());
    event.setTitle(updatedEvent.getTitle());
    event.setDescription(updatedEvent.getDescription());
    event.setImage(updatedEvent.getImage());
    event.setTicket_link(updatedEvent.getTicket_link());
    event.setPrice(updatedEvent.getPrice());
    event.setContact(updatedEvent.getContact());
    event.set_cancelled(updatedEvent.is_cancelled());
    event.setAdditional_information(updatedEvent.getAdditional_information());
    return eventRepository.save(event);
  }

  public void deleteEvent(Integer id) {
    eventRepository.deleteById(id);
  }

}

