package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import model.Actions;
import model.Fixture;
import model.Player;
import model.Team;

public class GameRunner {
  private Fixture fixture;
  private Team home;
  private Team away;
  private List<Player> homePlayers;
  private List<Player> awayPlayers;
  private Map<Actions, String> timeline;

  public GameRunner(Fixture fixture) {
    this.fixture = fixture;
    this.home = fixture.getHomeTeam();
    this.away = fixture.getAwayTeam();
    this.homePlayers = home.getPlayers();
    this.awayPlayers = away.getPlayers();
    this.timeline = new HashMap<>();
  }

  public Fixture getFixture() {
    return fixture;
  }

  public void setFixture(Fixture fixture) {
    this.fixture = fixture;
  }

  public Team getHome() {
    return home;
  }

  public void setHome(Team home) {
    this.home = home;
  }

  public Team getAway() {
    return away;
  }

  public void setAway(Team away) {
    this.away = away;
  }

  public List<Player> getHomePlayers() {
    return homePlayers;
  }

  public void setHomePlayers(List<Player> homePlayers) {
    this.homePlayers = homePlayers;
  }

  public List<Player> getAwayPlayers() {
    return awayPlayers;
  }

  public void setAwayPlayers(List<Player> awayPlayers) {
    this.awayPlayers = awayPlayers;
  }

  public Map<Actions, String> getTimeline() {
    return timeline;
  }

  public void setTimeline(Map<Actions, String> timeline) {
    this.timeline = timeline;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameRunner that = (GameRunner) o;
    return Objects.equals(fixture, that.fixture) &&
        Objects.equals(home, that.home) &&
        Objects.equals(away, that.away) &&
        Objects.equals(homePlayers, that.homePlayers) &&
        Objects.equals(awayPlayers, that.awayPlayers) &&
        Objects.equals(timeline, that.timeline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fixture, home, away, homePlayers, awayPlayers, timeline);
  }

  @Override
  public String toString() {
    return "GameRunner{" +
        "fixture=" + fixture +
        ", home=" + home +
        ", away=" + away +
        ", homePlayers=" + homePlayers +
        ", awayPlayers=" + awayPlayers +
        ", timeline=" + timeline +
        '}';
  }
}
