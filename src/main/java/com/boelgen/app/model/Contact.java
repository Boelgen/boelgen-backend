package com.boelgen.app.model;

import java.net.URL;

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
@Table(name = "kontakt")
public class Contact {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int contact_id;
  private String name;
  private String email;
  private String phone;
  private String title;
  private URL imageUrl;
}
