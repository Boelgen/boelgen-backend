package com.boelgen.app.model;
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
@Table(name = "event", schema = "boelgen")
public class Event {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long event_id;
  private Date date;
  private String title;
  private String description;
  private String image;
  private String ticket_link;
  private String price;
  @ManyToOne
  @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
  private Contact contact;
  private boolean is_cancelled;
  private String additional_information;
}
