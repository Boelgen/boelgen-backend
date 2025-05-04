package com.boelgen.app.repository;

import org.springframework.stereotype.Repository;
import com.boelgen.app.model.Contact;

@Repository
public interface ContactRepository extends org.springframework.data.jpa.repository.JpaRepository<Contact, Integer> {
  Contact findByName(String name);

}
