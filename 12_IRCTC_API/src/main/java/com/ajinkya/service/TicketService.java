package com.ajinkya.service;

import java.util.Collection;

import com.ajinkya.bindings.Passanger;
import com.ajinkya.bindings.Ticket;

public interface TicketService {
	Ticket bookTicket(Passanger p);
	
	Collection<Ticket> getAllTickets();
}
