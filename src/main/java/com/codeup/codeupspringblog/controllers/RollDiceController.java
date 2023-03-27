package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String diceGuess(Model model) {
        model.addAttribute("guess", 0);
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int roll = new Random().nextInt(6) + 1;
        model.addAttribute("roll", roll);
        model.addAttribute("guess", guess);
        model.addAttribute("message", guess == roll ? "You guessed it!" : "Sorry, try again.");
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String handleRollDiceForm(@RequestParam int guess) {
        return "redirect:/roll-dice/" + guess;
    }

}





