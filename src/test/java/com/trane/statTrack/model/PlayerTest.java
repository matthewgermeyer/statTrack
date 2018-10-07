package com.trane.statTrack.model;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PlayerTest {
  private List<String> roster;
  private List<Player> players;
  private Player testPlayer;

  @Before
  public void setUp() throws Exception {
    roster = Arrays.asList("t1", "t2");
    players = Team.generatePlayersFromRoster(roster);
    testPlayer = new Player("testPlayer");
  }

  @Test
  public void generatePlayersFromRosterYieldsAListOfPlayerObjects() throws Exception {
    List<Player> testPlayers = Team.generatePlayersFromRoster(roster);

    assertEquals(testPlayers.get(0), new Player("t1"));
    assertNotNull("testPlayers should have 2 Player objects", testPlayers);
  }




}
