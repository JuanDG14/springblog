package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String diceRoll() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{num}")
    public String display(@PathVariable int num, Model model) {
        int randomNum = (int) (Math.random() * 6) + 1;
        boolean check = randomNum == num;
        model.addAttribute("num", num);
        model.addAttribute("randomNum", randomNum);
        model.addAttribute("check", check);
        return "dice-roll-check";
    }
}
