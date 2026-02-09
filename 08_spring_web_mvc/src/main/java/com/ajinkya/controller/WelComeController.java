package com.ajinkya.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelComeController {
	
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMessage() {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("msg", "Welcome Ajinkya");
	    mav.setViewName("index"); // Maps to index.html
	    return mav;
	}
	
	@GetMapping("/date")
    public ModelAndView getDate() {
        ModelAndView mView = new ModelAndView();
        mView.addObject("date", new Date()); // Add date object
        mView.setViewName("index"); // Ensure the view is set
        return mView; // Return ModelAndView object
    }
}
