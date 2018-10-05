package com.trane.statTrack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Team {
  //counter for players instantiated
  private static Long playerCounter = 1L;
  private Long id;
  private String teamName;
  private String managerName;
  private String homeGround;
  List<String> playerNames;
  List<Player> players;

  private static final String SPURS_NAME = "Tottenham Hotspur FC";
  private static final String SPURS_MANAGER = "Mauricio Pochetino";
  private static final String SPURS_GROUND = "White Hart Lane";
  private static final List<String> SPURS_PLAYERS_NAMES = Arrays.asList(
      "Hugo Lloris",
      "Toby Alderweireld",
      "Jan Vertonghen",
      "Davinson Sanchez",
      "Kieren Trippier",
      "Ben Davies",
      "Moussa Dembele",
      "Eric Dier",
      "Christian Eriksen",
      "Erik Lamela",
      "Son Heung Min",
      "Harry Kane",
      "Lucas Moura",
      "Danny Rose"
  );

  private static final String ARSENAL_NAME = "Arsenal FC";
  private static final String ARSENAL_MANAGER = "Unai Emergy";
  private static final String ARSENAL_GROUND = "Emirates Stadium";
  private static final List<String> ARSENAL_PLAYERS_NAMES = Arrays.asList(
      "Petr Cech",
      "Bernd Leno",
      "Sokratis",
      "Koscielny",
      "Bellerin",
      "Mustafi",
      "Monreal",
      "Mesut Ozil",
      "Lucas Torreira",
      "Matteo Guendouzi",
      "Granit Xhaka",
      "Lacazette",
      "Aubameyang",
      "Welbeck"
  );

  //Constructors (3) : short, long, empty
  public Team(String teamName) {
    this.teamName = teamName;
    this.managerName= "not set";
    this.homeGround= "not set";
    this.playerNames = new ArrayList<>();
    this.players = new ArrayList<>();

  }

  public Team(String teamName, String managerName, String homeGround,
              List<String> playerNames) {
    this.teamName = teamName;
    this.managerName = managerName;
    this.homeGround = homeGround;
    this.playerNames = playerNames;
    this.players = generatePlayers(playerNames);
  }

  public Team() {}

  //getters and setters
  public String getTeamName() {
    return teamName;
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

  public List<String> getPlayerNames() {
    return playerNames;
  }

  public void setPlayerNames(List<String> playerNames) {
    this.playerNames = playerNames;
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
    return Objects.equals(teamName, team.teamName) &&
        Objects.equals(managerName, team.managerName) &&
        Objects.equals(homeGround, team.homeGround) &&
        Objects.equals(playerNames, team.playerNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(teamName, managerName, homeGround, playerNames);
  }

  @Override
  public String toString() {
    String rosterString = rosterString(playerNames);
    String result = String.format(
        " Team: %s%n " +
            "Manager: %s%n Venue: %s%n%n " +
            "Roster: %n%s",
        teamName,
        managerName,
        homeGround,
        rosterString);
    return result.replace("[", "").replace("]", "").replace(",","");

  }

  private String rosterString(List<String> playerNames) {
    String result = "";
    if (playerNames != null) {
      for (String name : playerNames) {
        result += name + String.format("%n");
      }
    }
    return result;
  }

  public static Team generateSpursTeam() {
    Team spurs = new Team(SPURS_NAME, SPURS_MANAGER, SPURS_GROUND, SPURS_PLAYERS_NAMES);
    spurs.setPlayers(generatePlayers(SPURS_PLAYERS_NAMES));
    System.out.printf("%n%n---> Generating Spurs%n%s %n%n", spurs.toString());
    return spurs;
  }

  public static Team generateArsenalTeam() {
    Team arsenal = new Team(ARSENAL_NAME, ARSENAL_MANAGER, ARSENAL_GROUND, ARSENAL_PLAYERS_NAMES);
    arsenal.setPlayers(generatePlayers(ARSENAL_PLAYERS_NAMES));
    System.out.printf("%n%n---> Generating Arsenal%n%s %n%n", arsenal.toString());

    return arsenal;
  }

  public static List<Player> generatePlayers(List<String> roster) {
    ArrayList<Player> players = new ArrayList<>();
    if (roster != null) {
      for (String name : roster) {
        Player p = new Player(name);
        p.setId(playerCounter);
        playerCounter++;
        players.add(p);
      }
    }
    return players;
  }

}//class
