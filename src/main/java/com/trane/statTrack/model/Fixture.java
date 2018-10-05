package com.trane.statTrack.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Fixture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private List<Team> teams;
  private String homeTeamName;
  private String awayTeamName;

  private Team homeTeam;
  private Team awayTeam;
  @Column
  private String venue;
  @Column
  private String date;

  //constructors 2 : full(minus id) and empty
  public Fixture(Team home, Team away) {
    this.teams = Arrays.asList(home, away);
    this.homeTeam = home;
    this.awayTeam = away;
    this.homeTeamName = home.getTeamName();
    this.awayTeamName = away.getTeamName();
    this.venue = home.getHomeGround();
    this.date = LocalDateTime.now().toString().substring(0, 10);
  }

  public Fixture() {}

  //getters and setters


  public List<Team> getTeams() {
    return teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public void setHomeTeamName(String homeTeamName) {
    this.homeTeamName = homeTeamName;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public void setAwayTeamName(String awayTeamName) {
    this.awayTeamName = awayTeamName;
  }

  public Team getHomeTeam() {
    return homeTeam;
  }

  public void setHomeTeam(Team homeTeam) {
    this.homeTeam = homeTeam;
  }

  public Team getAwayTeam() {
    return awayTeam;
  }

  public void setAwayTeam(Team awayTeam) {
    this.awayTeam = awayTeam;
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  //overriden methods
  @Override
  public String toString() {
    return "Fixture{" +
        ", homeTeamName='" + homeTeamName + '\'' +
        ", awayTeamName='" + awayTeamName + '\'' +
        ", venue='" + venue + '\'' +
        +'\'' +
        ", date='" + date + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fixture fixture = (Fixture) o;
    return Objects.equals(teams, fixture.teams) &&
        Objects.equals(homeTeamName, fixture.homeTeamName) &&
        Objects.equals(awayTeamName, fixture.awayTeamName) &&
        Objects.equals(homeTeam, fixture.homeTeam) &&
        Objects.equals(awayTeam, fixture.awayTeam) &&
        Objects.equals(venue, fixture.venue) &&
        Objects.equals(date, fixture.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(teams, homeTeamName, awayTeamName, homeTeam, awayTeam, venue, date);
  }

  public static Fixture generateNorthLondonDerby() {
    Fixture nld = new Fixture(Team.generateSpursTeam(), Team.generateArsenalTeam());
    return nld;
  }



}
