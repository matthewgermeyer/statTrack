package com.trane.statTrack.player;

import com.trane.statTrack.config.BaseEntity;
import com.trane.statTrack.team.Team;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Player extends BaseEntity {

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
    super();
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name) &&
        Objects.equals(team, player.team) &&
        Objects.equals(position, player.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, team, position);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Player{");
    sb.append("name='").append(name).append('\'');
    sb.append(", team=").append(team);
    sb.append(", position='").append(position).append('\'');
    sb.append('}');
    return sb.toString();
  }
}


