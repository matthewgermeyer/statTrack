package com.trane.statTrack.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player {
  private Long id;
  private String name;
  private Map<Actions, Detail> statbook;

  //constructors
  public Player() {
  }

  public Player(String name) {

    this.name = name;
    this.statbook = new HashMap<>();

  }

  //getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Map<Actions, Detail> getStatbook() {
    return statbook;
  }

  public void setStatbook(Map<Actions, Detail> statbook) {
    this.statbook = statbook;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //Overriden methods
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return String.format("%s%n", name);
  }

  //Statbook methods
  //TODO: write method to jot into statbook / write test cases
  public void jot(Actions toAdd, Detail detail) {
    if (statbook != null) {
      statbook.put(toAdd, detail);
      System.out.printf(
          "%n ------> Added Action : %s%n " +
              "Description: %s%n",
          toAdd.toString(),
          detail.toString());
      setStatbook(statbook);

    }
    Map<Actions, Detail> statbook = new HashMap<>();
    statbook.put(toAdd, detail);
    setStatbook(statbook);

  }


}


