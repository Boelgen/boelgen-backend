package com.boelgen.app.model;
import java.net.URL;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int event_id;
  private String type;
  private Date date;
  private String name;
  private String description;
  private URL image;
  private URL ticket_link;
  private float price;
  @ManyToOne
  @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
  private Contact contact;
}
