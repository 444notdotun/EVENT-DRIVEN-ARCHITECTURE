package com.managmentapplication.taskmanagement.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Clock;
import java.time.LocalDateTime;
@Data
@Entity
public class Audition {
 @Id
  private String id;
  private String Action;
  private LocalDateTime date;

  public Audition() {
    this.date = LocalDateTime.now();
  }

}
