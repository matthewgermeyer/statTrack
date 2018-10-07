package com.trane.statTrack.data;

import com.trane.statTrack.model.Team;

import java.util.List;

public interface TeamDAO {

  List<Team> findAll();
  Team findById(Long id);
  Long save(Team team);
  void update(Team team);
  void delete(Team team);
}
