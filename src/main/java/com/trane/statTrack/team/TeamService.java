package com.trane.statTrack.team;

import java.util.List;

public interface TeamService {
  List<Team> findAll();
  Team findById(Long id);
  void save(Team team);
  void delete(Team team);


}
