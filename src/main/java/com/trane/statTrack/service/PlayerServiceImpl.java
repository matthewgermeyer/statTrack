package com.trane.statTrack.service;

import com.trane.statTrack.data.PlayerDAO;
import com.trane.statTrack.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
  @Autowired
  TeamService teamService;
  @Autowired
  PlayerDAO playerDAO;

  @Override
  public List<Player> findAll() {
   return playerDAO.findAll();
  }

  @Override
  public Player findById(Long id) {
    return playerDAO.findById(id);
  }

  @Override
  public void save(Player player) {
    playerDAO.save(player);
  }

  @Override
  public void update(Player player) {
    playerDAO.update(player);
  }

  @Override
  public void delete(Long id) {
    playerDAO.delete(id);
  }

}
