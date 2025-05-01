package com.boelgen.app.controller;

import org.springframework.stereotype.Controller;

import com.boelgen.app.service.EventService;

@Controller
public class EventController {
  public final EventService eventService;
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }
}
