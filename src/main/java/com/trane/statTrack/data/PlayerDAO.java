package com.trane.statTrack.data;

import com.trane.statTrack.model.Player;

import java.util.List;

public interface PlayerDAO {

  List<Player> findAll();
  Player findById(Long id);
  void save(Player player);
  void update(Player player);
  void delete(Long id);


}
