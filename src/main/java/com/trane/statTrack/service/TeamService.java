package com.trane.statTrack.service;

import com.trane.statTrack.model.Team;

import java.util.List;

public interface TeamService {
  List<Team> findAll();
  Team findById(Long id);
  void update(Team team);
  void save(Team team);
  void delete(Long id);
  Team generateSpursTeam();
  Team generateArsenalTeam();

}
