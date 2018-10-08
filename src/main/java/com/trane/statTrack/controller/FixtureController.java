package com.trane.statTrack.controller;

import com.trane.statTrack.service.FixtureService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixtureController {

  @Autowired
  private FixtureService fixtureService;

  @Autowired
  private TeamService teamService;

  @RequestMapping("/NLD")
  public String nldCaps() {
    return "NLD";
  }

  @RequestMapping("/nld")
  public String nld() {
    return "NLD";
  }


} //class
