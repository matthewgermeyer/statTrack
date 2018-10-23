package com.trane.statTrack.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
  @Autowired
  TeamRepository teams;

  @Override
  public List<Team> findAll() {
    List<Team> teamList = new ArrayList<>();
        for (Team t : teams.findAll()) {
          teamList.add(t);
        }
  return teamList;
  }

  @Override
  public Team findById(Long id) {
    return teams.findOne(id);
  }

  @Override
  public void save(Team team) {
    teams.save(team);
  }

  @Override
  public void delete(Team team) {
    teams.delete(team);
  }
}

