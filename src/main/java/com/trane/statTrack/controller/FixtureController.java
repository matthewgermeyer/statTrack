package com.trane.statTrack.controller;

import com.trane.statTrack.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixtureController {

  @Autowired
  FixtureService fixtureService;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/fixtures")
  public String fixtures() {
    return "fixtures";
  }
}
