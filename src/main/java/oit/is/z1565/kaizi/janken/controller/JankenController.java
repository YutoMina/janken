package oit.is.z1565.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1565.kaizi.janken.model.Entry;

@Controller
public class JankenController {
  @Autowired
  private Entry room;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("userName", loginUser);
    return "janken.html";
  }

  /*
   * @GetMapping("/janken.html")
   * public String janken2(Principal prin, ModelMap model) {
   * String loginUser = prin.getName();
   * this.room.addUser(loginUser);
   * model.addAttribute("room", this.room);
   * return "janken.html";
   * }
   */

  /*
   * @PostMapping("/janken")
   * public String jankenNamed(@RequestParam String username, ModelMap model) {
   *
   * model.addAttribute("userName", username);
   * return "janken.html";
   * }
   */

  @GetMapping("janken/{param}")
  public String jankenFight(@PathVariable Integer param, ModelMap model) {
    String[] pose = { "Gu", "Choki", "Pa" };
    int enemy = 3;
    if (param == enemy) {
      model.addAttribute("result", "Draw!");
    } else if ((param % 3) + 1 == enemy) {
      model.addAttribute("result", "You Win!");
    } else {
      model.addAttribute("result", "You Lose...");
    }
    model.addAttribute("user", pose[param - 1]);
    model.addAttribute("enemy", pose[enemy - 1]);
    return "janken.html";
  }

}
