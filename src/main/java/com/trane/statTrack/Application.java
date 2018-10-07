package com.trane.statTrack;

import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class Application {
  @Autowired
  private static TeamService teamService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

//    Team arsenal = teamService.generateArsenalTeam();
//    Team spurs = teamService.generateSpursTeam();
//    teamService.save(arsenal);
//    teamService.save(spurs);

  }


}




