package oit.is.z1565.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {


  @GetMapping("/janken.html")
  public String janken() {
    return "janken.html";
  }

  @GetMapping("/janken")
  public String janken2() {

    return "janken.html";
  }

  @PostMapping("/janken")

  public String jankenNamed(@RequestParam String username, ModelMap model) {

    model.addAttribute("userName", username);
    return "janken.html";
  }


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
