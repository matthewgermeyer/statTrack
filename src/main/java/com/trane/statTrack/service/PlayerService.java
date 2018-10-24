package com.trane.statTrack.service;

import com.trane.statTrack.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
  List<Player> findAll();
  Player findById(Long id);
  void save(Player player);
  void update(Player player);
  void delete(Long id);

}
