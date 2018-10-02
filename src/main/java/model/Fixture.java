package model;

import java.time.LocalDateTime;
import java.util.List;

public class Fixture {
  List<Team> teams;
  String homeTeam;
  String awayTeam;
  String venue;
  String result;
  String date;


  public Fixture(String homeTeam, String awayTeam, List<Team> teams) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.venue = "";
    this.result = "Game has not started";
    this.date = LocalDateTime.now().toString().substring(0,10);
    this.teams = teams;
  }

  public String getHomeTeam() {
    return homeTeam;
  }

  public String getAwayTeam() {
    return awayTeam;
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
    this.date = LocalDateTime.now().toString();
  }

  @Override
  public String toString() {
    return "Fixture{" +
        ", homeTeam='" + homeTeam + '\'' +
        ", awayTeam='" + awayTeam + '\'' +
        ", venue='" + venue + '\'' +
        ", result='" + result + '\'' +
        ", date='" + date + '\'' +
        '}';
  }
}
