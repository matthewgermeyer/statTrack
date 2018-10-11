package com.trane.statTrack.model;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fixture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String opponent;
  private String date;
  boolean isHome;

  //constructors
  public Fixture(String opponent, String date, String site) {
    this.opponent = opponent;
    this.date = date;
    if (site.toLowerCase().equals("home")) {
      this.isHome=true;
    } else {
      isHome = false;
    }
  }

  public Fixture() {
  }

  //getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOpponent() {
    return opponent;
  }

  public void setOpponent(String opponent) {
    this.opponent = opponent;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public boolean isHome() {
    return isHome;
  }

  public void setHome(boolean home) {
    isHome = home;
  }

  //overriden methods
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fixture fixture = (Fixture) o;
    return Objects.equals(id, fixture.id) &&
        Objects.equals(opponent, fixture.opponent) &&
        Objects.equals(date, fixture.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, opponent, date);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(opponent);
    sb.append(isHome ? (" | home") : (" | away"));
    sb.append("on " + date);
    return sb.toString();
  }
}
