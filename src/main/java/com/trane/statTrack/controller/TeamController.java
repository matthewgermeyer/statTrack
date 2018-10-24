package com.trane.statTrack.controller;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Team;
import com.trane.statTrack.service.TeamService;
import com.trane.statTrack.model.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
public class TeamController {
  @Autowired
  TeamService teamService;

  @RequestMapping("/")
  public String index() {
    return "redirect:/teams";
  }

  // All Teams
  @RequestMapping("/teams")
  public String listTeams(Model model) {

    List<Team> teams = teamService.findAll();
    model.addAttribute("teams", teams);
    return "team/index";
  }

  // Single Team
  @RequestMapping("/teams/{id}")
  public String team(@PathVariable Long id, Model model) {
    Team team = teamService.findById(id);
    List<Player> players = team.getPlayers();
    List<Player> starters = new ArrayList<>();

    if (starters.size() > 0){
      model.addAttribute("starters", starters);
    }
    /*
    Originally populated names using a lambda, but can access this off the player object.
    List<String> names = new ArrayList<>();
    players.forEach(player -> names.add(player.getName()));
    model.addAttribute("names",names);
    */
    model.addAttribute("team", team);
    model.addAttribute("players", players);
    return "team/detail";
  }

  //Edit form (Edit and Add use the same form)
  @RequestMapping("/teams/{teamId}/edit")
  public String formEditTeam(@PathVariable Long teamId, Model model) {
    if (model.containsAttribute("team")) {
      model.addAttribute("team", teamService.findById(teamId));
    }

    model.addAttribute("action", String.format("/teams/%s", teamId));
    model.addAttribute("heading", "Edit Team");
    model.addAttribute("submit", "Edit");

    return "team/form";
  }

  //Add Team - form
  @RequestMapping("teams/add")
  public String addTeam(Model model) {

    if (!model.containsAttribute("team")) {
      model.addAttribute("team", new Team());
    }

    model.addAttribute("action", "/teams");
    model.addAttribute("heading", "New Team");
    model.addAttribute("submit", "Add");

    return "team/form";
  }

  //Add team (POST)
  @RequestMapping(value = "/teams", method = RequestMethod.POST)
  public String addTeam(@Valid Team team,
                        BindingResult result,
                        RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      redirectAttributes
          .addFlashAttribute("org.springframework.validation.BindingResult.team", result);
      redirectAttributes.addFlashAttribute("team", team);

      return "redirect:/teams/add";
    }
    teamService.save(team);

    redirectAttributes.addFlashAttribute("flash", new FlashMessage("Team added!",
        FlashMessage.Status.SUCCESS));

    return "redirect:/teams";
  }

  //Update team (POST)
  @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.POST)
  public String formEditTeam(@Valid Team team,
                             RedirectAttributes redirectAttributes,
                             BindingResult result) {

    //check validation for errors
    if (result.hasErrors()) {
      //errors exist -> warn the user with a flash message
      redirectAttributes.addFlashAttribute("org.springframe.validation.BindingResult.team", result);
      redirectAttributes.addFlashAttribute("team", team);
      return String.format("redirect:/teams/%s/edit", team.getId());
    }
    // green path ->
    // save the team
    teamService.save(team);
    //redirect attributes Team team, a flash message with success, result status
    redirectAttributes.addFlashAttribute("flash",
        new FlashMessage("Category successfully updated!", FlashMessage.Status.SUCCESS));
    return "team/teams";
  }


  //Delete Team
  @RequestMapping(value = "/teams/{teamId}/delete", method = RequestMethod.POST)
  public String deleteTeam(@PathVariable Long teamId, RedirectAttributes redirectAttributes) {

    Team team = teamService.findById(teamId);
    if (team.getPlayers().size() > 0) {

      redirectAttributes.addFlashAttribute("flash",
          new FlashMessage("Only empty categories can be deleted.", FlashMessage.Status.FAILURE));
    }
    try {
      teamService.delete(teamService.findById(teamId));
    } catch (TeamNotEmptyException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

    redirectAttributes
        .addFlashAttribute("flash", new FlashMessage("Team deleted!", FlashMessage.Status.SUCCESS));
    return String.format("redirect:/teams/%s/edit", teamId);

  }

  public class TeamNotEmptyException extends RuntimeException{
  }

}
