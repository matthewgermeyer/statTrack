package com.trane.statTrack.service;

import com.trane.statTrack.data.TeamDAO;
import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
  @Autowired
  TeamDAO teamDAO;

  @Override
  public List<Team> findAll() {
    return teamDAO.findAll();
  }

  @Override
  public Team findById(Long id) {
    return teamDAO.findById(id);
  }

  @Override
  public void save(Team team) {
    teamDAO.save(team);
  }

  @Override
  public void update(Team team) {
    teamDAO.update(team);
  }

  @Override
  public void delete(Team team) {
    teamDAO.delete(team);
  }

  @Override
  public List<Player> allPlayers() {
    return teamDAO.allPlayers();
  }
}
