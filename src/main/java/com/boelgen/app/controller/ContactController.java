package com.boelgen.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.boelgen.app.model.Event;
import com.boelgen.app.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boelgen.app.model.Contact;

@Controller
public class ContactController {
  
  public final ContactService contactService;
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  @GetMapping("/contacts")
  public ResponseEntity<List<Contact>> getAllContacts() {
      List<Contact> contacts = contactService.getAllContacts();
      return ResponseEntity.ok(contacts);
  }

}
