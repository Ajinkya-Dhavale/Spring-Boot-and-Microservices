package com.ajinkya.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ajinkya.binding.Passanger;
import com.ajinkya.binding.Ticket;
import com.ajinkya.service.BookTicketService;

import reactor.core.publisher.Mono;

@Controller
public class BookTicketController {
	@Autowired
	private BookTicketService service;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		Mono<Ticket[]> list = service.getAllTicket();
		model.addAttribute("tickets", list); // Add Mono to the model (handled asynchronously)
		model.addAttribute("p", new Passanger());
		return "index";		
	}
	
	@PostMapping("/book_ticket")	
	public String bootTicket(Passanger p, Model model)
	{
	    model.addAttribute("successMsg", "Ticket Booked Successfully");

	    service.bookTicket(p)
	        .doOnSuccess(ticket -> model.addAttribute("ticket", ticket))
	        .subscribe(); // Non-blocking call
	    service.getAllTicket()
	        .doOnNext(tickets -> model.addAttribute("tickets", Arrays.asList(tickets)))
	        .subscribe();

	    model.addAttribute("p", new Passanger());
	    
	    // Redirect to the index page
	    return "redirect:/";  // Use "redirect:" to redirect to the home page
	}

}
