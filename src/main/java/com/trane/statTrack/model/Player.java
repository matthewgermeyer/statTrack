package com.trane.statTrack.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable = false, nullable = false)
  private Long id;

  @NotNull
  @Size(min = 4, max = 30)
  private String name;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "fk_team")
  private Team team;

  @NotNull
  private String position;


  //default constructor for JPA
  public Player() {
  }

  public Player(String name) {
    this.name = name;
  }

  //getters and setters
  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
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
    return Objects.equals(id, player.id) &&
        Objects.equals(name, player.name) &&
        Objects.equals(team, player.team);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, team);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Player: ");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", team=").append(team);
    sb.append(", position='").append(position).append('\'');
    sb.append('}');
    return sb.toString();
  }
}


