package com.trane.statTrack.controller;

import com.trane.statTrack.model.Actions;
import com.trane.statTrack.model.Detail;
import com.trane.statTrack.model.Fixture;
import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tracker {
  private static BufferedReader reader;
  private Fixture fixture;
  private Team team;


  public Tracker(Fixture fixture) {
    this.fixture = fixture;
    this.team = fixture.getHomeTeam();
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public Fixture getFixture() {
    return fixture;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public void showPlayerChoices() {
    int count = 1;
    for (Player p : team.getPlayers()) {
      System.out.printf("%s) %s%n", count, p.getName());
      count++;
    }
  }

  public void track() throws IOException {
    boolean quit = false;
    do {
      showPlayerChoices();
      if (!playerPicker(reader.readLine())) {
        quit = true;
      }
    }
    while (!quit);
  }

  private boolean playerPicker(String choice) throws IOException {
    List<Player> players = team.getPlayers();
    if (choice.equals("quit")) {
      return false;
    }
    int listChoice = Integer.parseInt(choice) - 1;
    if (listChoice > players.size()) {
      throw new IllegalArgumentException("out of bounds!");
    } else {
      String selectedPlayerName = players.get(listChoice).getName();
      System.out.printf("You selected -> %s%n", selectedPlayerName);

      for (String n : team.getPlayerNames()) {
        if (n.equals(selectedPlayerName)) {
          Player match = team.getPlayerByName(n);
          actionSheetPicker(match);
        }
      }
    }
    return true;
  } //player picker

  private void actionSheetPicker(Player match) throws IOException {
    int count = 1;
    List<Actions> actionList = new ArrayList<>();
    for (Actions a : Actions.values()) {
      actionList.add(a);
      System.out.printf("%d) %s%n ", count, a);
      count++;
    }
    System.out.printf("Choose an action: %n");
    int listChoice = Integer.parseInt(reader.readLine());
    Actions toAdd = actionList.get(listChoice -1);
    match.jot(toAdd, new Detail(new Date().toString(),"looked good!"));



//

//    Map<Actions, List<Detail>> statbook = new HashMap<>();
//    Detail detail = new Detail(Detail.timeStamp()
//        , "good pass");
//    List<Detail> details = new ArrayList<>();
//    details.add(detail);
//    statbook.put()

  }
} //class
