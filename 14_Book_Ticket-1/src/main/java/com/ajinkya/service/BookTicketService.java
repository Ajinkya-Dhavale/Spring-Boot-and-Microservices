package com.ajinkya.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.ajinkya.binding.Passanger;
import com.ajinkya.binding.Ticket;

import reactor.core.publisher.Mono;

@Service
public class BookTicketService {

	public Mono<Ticket[]> getAllTicket() {
		String url="http://localhost:8080/tickets";
		
		WebClient webClient=WebClient.create();
		Mono<Ticket[]> mono_tickets=  webClient.get().uri(url).retrieve().bodyToMono(Ticket[].class);
		
		return mono_tickets;
	}

	public Mono<Ticket> bookTicket(Passanger p) {
		String url="http://localhost:8080/ticket";
		WebClient webClient=WebClient.create();
		Mono<Ticket> mono_tickets= webClient.post()
				.uri(url)
				.body(BodyInserters.fromValue(p))
				.retrieve()
				.bodyToMono(Ticket.class);
		
		return mono_tickets;
	}

}
