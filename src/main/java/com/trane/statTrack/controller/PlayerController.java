package com.trane.statTrack.controller;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Position;
import com.trane.statTrack.service.PlayerService;
import com.trane.statTrack.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.validation.Valid;

@Controller
public class PlayerController {
  @Autowired
  PlayerService playerService;
  @Autowired
  TeamService teamService;

  @RequestMapping("/players")
  public String players(Model model) {

    List<Player> playerCards = playerService.findAll();
    model.addAttribute("cards", playerCards);
    return "player/players";
  }

  //form for adding new Player
  @RequestMapping("players/add")
  public String formNewPlayer(Player player, Model model) {
    model.addAttribute("player", new Player());
    model.addAttribute("positions", Position.values());
    return "player/form";
  }

  //adding a player will post to /players and redirect their with 302 response code.  Note the Player is passed into the method.  This comes from the form in the view.
  @RequestMapping(value = "/players", method = RequestMethod.POST)
  public String addPlayer(@Valid Player player, BindingResult result) {
    if (result.hasErrors()) {
      return "redirect/player/players/add";
    }
    playerService.save(player);
    return "redirect:player/players";
  }


  @RequestMapping("/player/{id}")
  public String playerDetail(@PathVariable Long id, ModelMap modelMap) {
    Player player = playerService.findById(id);
    modelMap.put("player", player);
    return "player/player-detail";
  }

}
