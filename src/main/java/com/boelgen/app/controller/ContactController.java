package com.boelgen.app.controller;

import org.springframework.stereotype.Controller;
import com.boelgen.app.service.ContactService;
import com.boelgen.app.model.Contact;
@Controller
public class ContactController {
  
  public final ContactService contactService;
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }
}
