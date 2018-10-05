package com.trane.statTrack.controller;

import com.trane.statTrack.model.Team;
import com.trane.statTrack.service.FixtureService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

  @RequestMapping("/NLD")
  public String nldCaps() {
    return "NLD";
  }

  @RequestMapping("/nld")
  public String nld() {
    return "NLD";
  }


  @RequestMapping(value = "/nld/tracker/update", method= RequestMethod.POST)
  public String trackerUpdatePost(ModelMap modelMap) {
    Team spurs = teamService.generateSpursTeam();
    List<String> roster = spurs.getPlayerNames();
    List<String> starters = Arrays.asList(
        roster.get(1),
        roster.get(4),
        roster.get(6),
        roster.get(9)
    );
    modelMap.addAttribute("team", spurs);
    modelMap.addAttribute("starters", starters);

    return "NLDtracker";
  }

}
