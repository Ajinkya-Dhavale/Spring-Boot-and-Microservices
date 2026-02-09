package com.ajinkya.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ajinkya.binding.Passanger;
import com.ajinkya.binding.Ticket;

@Service
public class BookTicketService {
	public Ticket bookTicket(Passanger p)
	{
		String url="http://localhost:8080/ticket";
		RestTemplate tr=new RestTemplate();
		
		ResponseEntity<Ticket> entity=tr.postForEntity(url, p, Ticket.class);
		Ticket ticket=entity.getBody();
		return ticket;	
	}
	public List<Ticket> getAllTicket()
	{
		String url="http://localhost:8080/tickets";
		RestTemplate tr=new RestTemplate();
		
		ResponseEntity<Ticket[]> entity=tr.getForEntity(url, Ticket[].class);
		Ticket[] t =entity.getBody();
		
		List<Ticket> list=Arrays.asList(t);
		
		return list;
			
	}
}
