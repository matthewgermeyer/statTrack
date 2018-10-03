package com.trane.statTrack.controller;

import com.trane.statTrack.model.Team;
import com.trane.statTrack.service.FixtureService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class FixtureController {

  @Autowired
  private FixtureService fixtureService;

  @Autowired
  private TeamService teamService;


  @RequestMapping("/")
  public String index() {
    return "NLD";
  }

  @RequestMapping("/nld")
  public String nld() {
    return "NLD";
  }

  @RequestMapping("/nld/tracker")
  public String trackerGet(Model model) {
    Team spurs = teamService.generateSpursTeam();
    List<String> roster = spurs.getPlayerNames();
    String instruction = "Select the starting players!";
    model.addAttribute("instruction", instruction);
    model.addAttribute("team", spurs);
    model.addAttribute("roster", roster);
    return "NLDtracker";
  }

  @RequestMapping(value = "/nld/tracker/update", method= RequestMethod.POST)
  public String trackerUpdatePost(Model model) {
    Team spurs = teamService.generateSpursTeam();
    List<String> roster = spurs.getPlayerNames();
    List<String> starters = Arrays.asList(
        roster.get(1),
        roster.get(4),
        roster.get(6),
        roster.get(9)
    );
    model.addAttribute("team", spurs);
    model.addAttribute("starters", starters);

    return "NLDtracker";
  }

}
