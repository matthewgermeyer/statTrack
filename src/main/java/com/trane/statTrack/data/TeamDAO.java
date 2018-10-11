package com.trane.statTrack.data;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;

import java.util.List;

public interface TeamDAO {

  List<Team> findAll();
  Team findById(Long id);
  void save(Team team);
  void update(Team team);
  void delete(Team team);

  List<Player> allPlayers();
}
