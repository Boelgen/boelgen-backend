package com.boelgen.app.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.boelgen.app.model.Event;

@Repository
public interface EventRepository extends org.springframework.data.jpa.repository.JpaRepository<com.boelgen.app.model.Event, Integer> {
    List<Event> findByDate(Date date);

    @Query("SELECT e FROM Event e WHERE e.title LIKE CONCAT('%', :query, '%') OR e.description LIKE CONCAT('%', :query, '%') OR e.additional_information LIKE CONCAT('%', :query, '%')")
    List<Event> searchEvents(@Param("query") String query);
}
