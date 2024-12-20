package com.ajinkya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajinkya.entity.User;
import com.ajinkya.repository.userRepository;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private userRepository repo;
	
	@Autowired
    private JavaMailSender mailSender;

	@GetMapping("/")
	public String GetIndexPage(Model model) {
		// Add a new user to the form model
		model.addAttribute("user", new User());
		return "index"; // Renders the index.html template
	}

	@PostMapping("/submitForm")
	public String submitForm(@Valid @ModelAttribute("user") User user, 
	                         BindingResult bindingResult, 
	                         RedirectAttributes redirectAttributes) {
	    if (bindingResult.hasErrors()) {
	        return "index"; // Return the form if validation fails
	    }

	    // Save the user to the database
	    repo.save(user); 

	    // Send an email to the user
	    try {
	        String subject = "Form Submission Confirmation";
	        String body = "Dear " + user.getUserName() + ",\n\nThank you for submitting the form. Your details have been recorded successfully.";
	        
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(user.getUserEmail());
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	    } catch (Exception e) {
	        // Log the error and set an error message for the user
	        redirectAttributes.addFlashAttribute("errorMessage", "Failed to send confirmation email.");
	        e.printStackTrace();
	    }

	    // Add a flash attribute to show the success message on the redirected page
	    redirectAttributes.addFlashAttribute("message", "Form submitted successfully!");

	    // Redirect to avoid form resubmission issues
	    return "redirect:/";
	}

}
