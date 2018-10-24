package com.trane.statTrack.model;

import static com.trane.statTrack.model.Team.generateArsenalTeam;
import static com.trane.statTrack.model.Team.generateSpursTeam;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FixtureTest {
  private Fixture nldTest;
  private List<Team> teams;


  @Before
  public void setUp() throws Exception {
    nldTest = Fixture.generateNorthLondonDerby();
    teams = Arrays.asList(generateSpursTeam(), generateArsenalTeam());
  }

  @Test
  public void testNorthLondonDerbySetsDate() throws Exception {

    assertNotNull("Date should be set!", nldTest.getDate());
  }

  @Test
  public void testNorthLondonDerbyHasTeams() throws Exception {

    assertNotNull("Teams should be set!", teams);
  }

  @Test
  public void testNorthLondonDerbyHasHomeTeamEqualToSpurs() throws Exception {

    assertEquals(generateSpursTeam(),nldTest.getHomeTeam());

  }

  @Test
  public void testNorthLondonDerbyHasAwayTeamEqualToArsenal() throws Exception {

    assertEquals(generateArsenalTeam(), nldTest.getAwayTeam());
  }

  @Test
  public void testNorthLondonDerbyatWhiteHartLane() throws Exception {

    assertEquals("White Hart Lane", nldTest.getVenue());
  }


}

