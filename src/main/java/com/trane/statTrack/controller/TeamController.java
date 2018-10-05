package com.trane.statTrack.controller;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;
import com.trane.statTrack.service.PlayerService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeamController {
  @Autowired
  TeamService teamService;
  @Autowired
  PlayerService playerService;



  @RequestMapping("/teams")
  public String listTeams(ModelMap modelMap) {
    List<Team> teams = teamService.findAll();
    modelMap.put("teams", teams);
    return "teams";
  }

  @RequestMapping("/team/{id}")
  public String team(@PathVariable Long id, ModelMap modelMap) {
    Team team = teamService.findById(id);
    List<String> roster = team.getPlayerNames();
    modelMap.put("team", team);
    modelMap.put("roster", roster);

    return "team";
  }

  @RequestMapping("/player/{id}")
  public String player(@PathVariable Long id, ModelMap modelMap) {
    Player player = playerService.findById(id);
    modelMap.put("player", player);
    return "player";

  }
}
