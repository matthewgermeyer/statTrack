package com.trane.statTrack.service;

import com.trane.statTrack.model.Team;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
  @Override
  public Team generateSpursTeam() {
     Team spurs = Team.generateSpursTeam();
     return spurs;
  }

  @Override
  public Team generateArsenalTeam() {
    Team arsenal = Team.generateArsenalTeam();
    return arsenal;
  }

  @Override
  public List<Team> findAll() {
    List<Team> teams = Arrays.asList(
        generateSpursTeam(),
        generateArsenalTeam()
    );
    return teams;
  }

  @Override
  public Team findById(Long id) {
    for (Team team : findAll()) {
      if (team.getId() == id) return team;
    }
    System.out.println("Could not find a team by that Id!");
    return null;
  }

  @Override
  public void save(Team team) {
    System.out.printf("Saving %s... %n", team.getTeamName());
  }

  @Override
  public void delete(Team team) {
    System.out.printf("Deleting %s ... %n", team.getTeamName());


  }
}
