package com.trane.statTrack.controller;

import com.trane.statTrack.model.Team;
import com.trane.statTrack.service.PlayerService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String listTeams(Model model) {
    List<Team> teams = teamService.findAll();
    model.addAttribute("teams", teams);
    return "team/teams";
  }

  @RequestMapping("/team/{id}")
  public String team(@PathVariable Long id, Model model) {
    Team team = teamService.findById(id);
    List<String> roster = team.getPlayerNames();
    model.addAttribute("team", team);
    model.addAttribute("roster", roster);

    return "team/team-detail";
  }

  @RequestMapping("/nld/tracker")
  public String trackerGet(ModelMap modelMap) {
    Team spurs = teamService.generateSpursTeam();
    Team arsenal = teamService.generateArsenalTeam();

    List<String> roster = spurs.getPlayerNames();
    modelMap.addAttribute("team", spurs);
    modelMap.addAttribute("roster", roster);
    return "NLDtracker";
  }


}
