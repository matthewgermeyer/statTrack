package com.trane.statTrack.model;

import static com.trane.statTrack.model.Team.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TeamTest {
  private Team testTeamShort;
  private Team testTeamLong;
  List<String> roster;

  @Before
  public void setUp() throws Exception {
    roster = Arrays.asList("t1", "t2");
    testTeamShort = new Team("testTeamShort");
    testTeamLong = new Team("testTeamLong", "testTeamManager", "testTeamHome", roster);
  }

  @Test
  public void shortTeamConstructorInstantiatesAllFieldsButId() throws Exception {
    // 1) expected, 2) actual
    assertEquals("testTeamShort", testTeamShort.getTeamName());
    assertEquals("not set", testTeamShort.getManagerName());
    assertEquals("not set", testTeamShort.getHomeGround());
    assertNotNull("Players should be instantiated", testTeamShort.getPlayers());
    assertNotNull("Roster should be instantiated ", testTeamShort.getRoster());

  }

  @Test
  public void longTeamConstructorInstantiatesAllFieldsButId() throws Exception {

    assertEquals("testTeamLong", testTeamLong.getTeamName());
    assertEquals("testTeamManager", testTeamLong.getManagerName());
    assertEquals("testTeamHome", testTeamLong.getHomeGround());
    assertEquals(roster, testTeamLong.getRoster());
    assertNotNull("Players should be instantiated", testTeamShort.getPlayers());
    assertNotNull("Roster should be instantiated ", testTeamShort.getRoster());
  }

  //generateSpurs Tests
  @Test
  public void generateSpursTeamSetsAllFields() throws Exception {
    Team spurs = generateSpursTeam();

    assertEquals("Tottenham Hotspur FC",spurs.getTeamName());
    assertEquals("Mauricio Pochetino",spurs.getManagerName());
    assertEquals("White Hart Lane",spurs.getHomeGround());
    assertNotNull("roster should not be Null!", spurs.getRoster());
    assertNotNull("players should not be Null!", spurs.getPlayers());

  }

  @Test
  public void generateArsenalTeamSetsAllFields() throws Exception {
    Team arsenal = generateArsenalTeam();

    assertEquals("Arsenal FC",arsenal.getTeamName());
    assertEquals("Unai Emergy",arsenal.getManagerName());
    assertEquals("Emirates Stadium",arsenal.getHomeGround());
    assertNotNull("roster should not be Null!", arsenal.getRoster());
    assertNotNull("players should not be Null!", arsenal.getPlayers());

  }

} //class


