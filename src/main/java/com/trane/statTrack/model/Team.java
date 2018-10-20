package com.trane.statTrack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "team")
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable = false, nullable = false)
  private Long id;
  @Column
  @Size(min = 4, max = 30)
  private String teamName;

  private String managerName;

  private String homeGround;

  @OneToMany(mappedBy = "team")
  List<Player> players;

  //Constructors
  public Team(String teamName) {
    this.teamName = teamName;
    this.managerName = "not set";
    this.homeGround = "not set";
    this.players = new ArrayList<>();
  }

  public Team(String teamName, String managerName, String homeGround,
              List<String> playerNames) {
    this.teamName = teamName;
    this.managerName = managerName;
    this.homeGround = homeGround;
    this.players = generatePlayersFromRoster(playerNames, this);
  }

  public Team() {
  }

  //getters and setters
  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public String getHomeGround() {
    return homeGround;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public void setHomeGround(String homeGround) {
    this.homeGround = homeGround;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    Team team = (Team) o;
    return Objects.equals(id, team.id) &&
        Objects.equals(teamName, team.teamName) &&
        Objects.equals(managerName, team.managerName) &&
        Objects.equals(homeGround, team.homeGround) &&
        Objects.equals(players, team.players);
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, teamName, managerName, homeGround, players);
  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", teamName='" + teamName + '\'' +
        ", managerName='" + managerName + '\'' +
        ", homeGround='" + homeGround + '\'' +
        ", players=" + players +
        '}';
  }

  //returns a list of Player objects from a roster, adds to team.
  public static List<Player> generatePlayersFromRoster(
      List<String> roster, Team team) {
    ArrayList<Player> players = new ArrayList<>();

    if (roster.size() > 0) {
      for (String name : roster) {
        Player newPlayer = new Player(name);
        newPlayer.setTeam(team);
        players.add(newPlayer);
      }
    }
    return players;
  }

  //returns a list of player names for the team
  public List<String> getRoster() {
    List<String> roster = new ArrayList<>();
    for (Player p : this.getPlayers()) {
      roster.add(p.getName());
    }
    return roster;
  }

  //Helper method for hibernate.
  public void signPlayer(Player player) {
    this.players.add(player);
    player.setTeam(this);

  }

}//class
