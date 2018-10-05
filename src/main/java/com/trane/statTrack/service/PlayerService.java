package com.trane.statTrack.service;

import com.trane.statTrack.model.Player;

import java.util.List;

public interface PlayerService {
  List<Player> findAll();
  Player findById(Long id);
  void save(Player player);
  void delete(Player player);
}
