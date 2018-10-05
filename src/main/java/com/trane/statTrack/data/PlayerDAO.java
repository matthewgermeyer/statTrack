package com.trane.statTrack.data;

import com.trane.statTrack.model.Player;

import java.util.List;

public interface PlayerDAO {

  Player findPlayerById(Long id);

  void update(Player player);

  Long savePlayer(Player player);

  void deletePlayerById(Long id);

  List<Player> fetchAllPlayers();

}
