package com.trane.statTrack.service;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerServiceImpl implements PlayerService{
  @Autowired
  TeamService teamService;

  @Override
  public List<Player> findAll() {
    List<Player> allPlayers = new ArrayList<>();
    for (Team team : teamService.findAll()) {
      allPlayers.addAll(team.getPlayers());
    }
    return allPlayers;
  }

  @Override
  public Player findById(Long id) {
    for (Player player : findAll()) {

      if (player.getId() == id ){
        return player;
      }
    }
    System.out.println("Could not find player by Id");
     return null;
  }

  @Override
  public void save(Player player) {
    System.out.println("Saving player ...");

  }

  @Override
  public void delete(Player player) {
    System.out.println("Deleting player ...");

  }
}
