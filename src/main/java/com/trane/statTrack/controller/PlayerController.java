package com.trane.statTrack.controller;

import com.trane.statTrack.model.Player;
import com.trane.statTrack.model.Position;
import com.trane.statTrack.service.PlayerService;
import com.trane.statTrack.service.TeamService;
import com.trane.statTrack.util.FlashMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

@Controller
public class PlayerController {
  @Autowired
  PlayerService playerService;
  @Autowired
  TeamService teamService;

  //All Players
  @RequestMapping("/players")
  public String players(Model model) {

    List<Player> playerCards = playerService.findAll();
    model.addAttribute("cards", playerCards);
    return "player/index";
  }

  //Single Player
  @RequestMapping("/player/{id}")
  public String playerDetail(@PathVariable Long id, ModelMap modelMap) {
    Player player = playerService.findById(id);
    modelMap.put("player", player);
    return "player/detail";
  }

  //form for adding new Player
  @RequestMapping("players/add")
  public String formNewPlayer(Player player, Model model) {
    model.addAttribute("player", new Player());
    model.addAttribute("positions", Position.values());
    return "player/form";
  }

  //form to edit a Player (shared with add)
  @RequestMapping("/players/{playerId}/edit")
  public String formEditPlayer(@PathVariable Long playerId, Model model) {

    //Check model for player attribute, in case we got here from a redirect.
    if (!model.containsAttribute("player")) {
      model.addAttribute("player", playerService.findById(playerId));
    }

    model.addAttribute("teams", teamService.findAll());
    model.addAttribute("action", String.format("/players/%s", playerId));
    model.addAttribute("heading", "Edit/Transfer Player");
    model.addAttribute("submit", "Update");

    return "player/form";
  }

  //post new player
  @RequestMapping(value = "/players", method = RequestMethod.POST)
  public String postAddPlayer(@Valid Player player,
                              RedirectAttributes redirectAttributes,
                              BindingResult result) {

    if (result.hasErrors()) {
      //if it does have errors craft a failure flash message
      redirectAttributes
          .addFlashAttribute("org.springframework.validation.BindingResult.player", result);
      //add redirect attribute for flash message and the player object.
      redirectAttributes.addFlashAttribute("player", player);
      //redirect
      return String.format("redirect:/players/%s/edit", player.getId());

    }
    playerService.save(player);
    redirectAttributes
        .addFlashAttribute("flash", new FlashMessage("Player added!", FlashMessage.Status.SUCCESS));

    return String.format("redirect:/players/%s", player.getId());
  }


  @RequestMapping(value = "/players/{playerId}", method = RequestMethod.POST)
  public String postPlayerUpdate(@Valid Player player,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      redirectAttributes.addFlashAttribute("player", player);
      redirectAttributes
          .addFlashAttribute("org.springframework.validation.BindingResult.player", result);
      return String.format("redirect:/players/{%s}/edit", player.getId());

    }
    playerService.save(player);
    redirectAttributes.addFlashAttribute("flash",
        new FlashMessage(("Successfully traded player!"),
            FlashMessage.Status.SUCCESS));
    return String.format("redirect:/players/%s/", player.getId());
  }

  //Delete player
  //TODO: Add some front end warning to ensure this doesnt happen by accident.
  @RequestMapping(value = "/players/{playerId}/delete", method = RequestMethod.POST)
  public String PostDeletePlayer(@PathVariable Long playerId,
                                 RedirectAttributes redirectAttributes) {

    Player player = playerService.findById(playerId);
    playerService.delete(player.getId());
    redirectAttributes.addFlashAttribute("flash",
        new FlashMessage("Player Deleted!",
            FlashMessage.Status.SUCCESS));

    return "redirect:/players";
  }

  // Search results
  @RequestMapping("/search")
  public String searchResults(@RequestParam String q, Model model) {
    List<Player> players = new ArrayList<>();

    model.addAttribute("players", players);
    return "player/players";
  }
}
