package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping({"/",""})
    public String getLogin(Model model) {      
        return "login";
    }	
}
