package com.boelgen.app.model;
import java.net.URL;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
  private String name;
  private Date date;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int event_id;
  private String description;
  private URL imageUrl;
  private URL ticketLink;
  private float price;
  private int contact_id;
  private String type;
}
