package com.ajinkya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ajinkya.binding.Passanger;
import com.ajinkya.binding.Ticket;
import com.ajinkya.service.BookTicketService;

@Controller
public class BookTicketController {
	@Autowired
	private BookTicketService service;
	
	@GetMapping("/")
	public String getIndex(Model model)
	{
		List<Ticket> list=service.getAllTicket();
		model.addAttribute("tickets",list);
		model.addAttribute("p",new Passanger());
		return "index";		
	}
	
	@PostMapping("/book_ticket")	
	public String bootTicket(Passanger p,Model model)
	{
		model.addAttribute("successMsg", "Ticket Book Successfully");
		Ticket ticket=service.bookTicket(p);
		List<Ticket> list=service.getAllTicket();
		model.addAttribute("tickets",list);
		model.addAttribute("p",new Passanger());		
		return "index";
	}
}
