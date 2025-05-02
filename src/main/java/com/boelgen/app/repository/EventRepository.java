package com.boelgen.app.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boelgen.app.model.Event;
@Repository
public interface EventRepository extends org.springframework.data.jpa.repository.JpaRepository<com.boelgen.app.model.Event, Integer> {
    List<Event> findByName(String name);
    List<Event> findByType(String type);
    List<Event> findByDate(Date date);
    List<Event> findByPrice(float price);
    List<Event> findByContactId(int contactId);

}
