package com.trane.statTrack.service;

import com.trane.statTrack.model.Team;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
  List<Team> findAll();
  Team findById(Long id);
  void save(Team team);
  void delete(Team team);


}
