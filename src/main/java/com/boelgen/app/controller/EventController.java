package com.boelgen.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.boelgen.app.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EventController {
  @Autowired
  public final EventService eventService;
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping("/events")
  public String getMethodName(@RequestParam(required = false) String param) {
      eventService.getAllEvents();
      return "events";
  }
  
}
