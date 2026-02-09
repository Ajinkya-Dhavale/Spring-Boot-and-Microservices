package com.ajinkya.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.bindings.Passanger;
import com.ajinkya.bindings.Ticket;
import com.ajinkya.service.TicketService;

@RestController
public class TicketRestController {
	@Autowired
	private TicketService service;
	
	@PostMapping("/ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passanger p) {
		Ticket ticket=service.bookTicket(p);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("/tickets")
	public ResponseEntity<Collection<Ticket>> getTickets()
	{
		return new ResponseEntity<Collection<Ticket>>(service.getAllTickets(),HttpStatus.OK);
	}
}
