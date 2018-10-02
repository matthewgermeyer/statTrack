package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Player {
  private String name;
  private int number;
  private Position position;
  private Map<Actions, Detail> statbook;

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

  private enum Position {
    GOALKEEPER,
    DEFENDER,
    MIDFIELDER,
    FORWARD
  }

  public Map<Actions, Detail> getStatbook() {
    return statbook;
  }

  public void setStatbook(Map<Actions, Detail> statbook) {
    this.statbook = statbook;
  }

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return number == player.number &&
        Objects.equals(name, player.name) &&
        position == player.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, number, position);
  }

  @Override
  public String toString() {
    return String.format("%s%n", name);


  }
}
