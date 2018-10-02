package model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fixture {
  private  List<Team> teams;
  private String homeTeamName;
  private String awayTeamName;
  private Team homeTeam;
  private Team awayTeam;
  private String venue;
  private String date;
  private String result;
  private Map<Object, String> timeline;


  public Fixture(Team home, Team away) {
    this.teams = Arrays.asList(home,away);
    this.homeTeam = home;
    this.awayTeam = away;
    this.homeTeamName = home.getTeamName();
    this.awayTeamName = away.getTeamName();
    this.venue = home.getHomeGround();
    this.result = "Game has not started";
    this.date = LocalDateTime.now().toString().substring(0,10);
    this.timeline = new HashMap<>();
  }

  public String gethomeTeamName() {
    return homeTeamName;
  }

  public String getawayTeamName() {
    return awayTeamName;
  }

  public String getVenue() {
    return venue;
  }

  public void setVenue(String venue) {
    this.venue = venue;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getDate() {
    return date;
  }

  public void setDate() {
    this.date = LocalDateTime.now().toString().substring(0,10);
  }

  public List<Team> getTeams() {
    return teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

  public Map<Object, String> getTimeline() {
    return timeline;
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

  public void setDate(String date) {
    this.date = date;
  }

  public static Fixture northLondonDerby() {
  Fixture northLondonDerby = new Fixture(
      Team.generateSpursTeam(),
      Team.generateArsenalTeam()
  );
  return northLondonDerby;
  }

  @Override
  public String toString() {
    return "Fixture{" +
        ", homeTeamName='" + homeTeamName + '\'' +
        ", awayTeamName='" + awayTeamName + '\'' +
        ", venue='" + venue + '\'' +
        ", result='" + result + '\'' +
        ", date='" + date + '\'' +
        '}';
  }
}
