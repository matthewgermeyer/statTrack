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

  //all teams
  @RequestMapping("/teams")
  public String listTeams(Model model) {
    //TODO: Move this later
    Team spurs = teamService.generateSpursTeam();
    Team arsenal = teamService.generateArsenalTeam();
    teamService.save(spurs);
    teamService.save(arsenal);

    List<Team> teams = teamService.findAll();
    model.addAttribute("teams", teams);
    return "team/index";
  }

  //team detail
  @RequestMapping("/teams/{id}")
  public String team(@PathVariable Long id, Model model) {
    Team team = teamService.findById(id);
    model.addAttribute("team", team);
    return "team/detail";
  }

  @RequestMapping("/teams/{id}/recruit")
  public String addPlayerToTeam(@PathVariable Long id, Model model) {

    Team team = teamService.findById(id);
    return "player/form";
  }




  @RequestMapping("/nld/tracker")
  public String trackerGet(ModelMap modelMap) {
    Team spurs = teamService.generateSpursTeam();

    List<String> roster = spurs.getRoster();
    modelMap.addAttribute("team", spurs);
    modelMap.addAttribute("roster", roster);
    return "NLDtracker";
  }


}
