package com.ajinkya.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {

    // GET method for displaying the form
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("result", ""); // Pass an empty result for initial load
        return "index"; // It will look for index.html in the templates folder
    }

    // POST method for calculating the sum
    @PostMapping("/add")
    public String addNumbers(@RequestParam("number1") int number1, @RequestParam("number2") int number2, Model model) {
        int sum = number1 + number2;
        model.addAttribute("result", sum); // Add result to the model
        return "index"; // Return to the index view after the sum is processed
    }
}
