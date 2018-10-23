package com.trane.statTrack.player;

import java.util.List;

public interface PlayerService {
  List<Player> findAll();
  Player findById(Long id);
  void save(Player player);
  void update(Player player);
  void delete(Long id);

}
