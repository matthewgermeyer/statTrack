package com.trane.statTrack.service;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;

import java.util.List;

public interface TeamService {
  List<Team> findAll();
  List<Player> allPlayers();
  Team findById(Long id);
  void update(Team team);
  void save(Team team);
  void delete(Team team);


}
