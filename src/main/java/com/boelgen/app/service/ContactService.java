package com.boelgen.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boelgen.app.repository.ContactRepository;
import com.boelgen.app.model.Contact;
@Service
public class ContactService {
  @Autowired
  ContactRepository contactRepository;
  
  public ContactService(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }
  public Contact getContactByName(String name) {
    return contactRepository.findByName(name);
  }
  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }
  public Contact getContactById(int id) {
    return contactRepository.findById(id).orElse(null);
  }
}
