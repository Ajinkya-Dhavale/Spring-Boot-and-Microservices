package com.ajinkya.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ajinkya.bindings.Passanger;
import com.ajinkya.bindings.Ticket;

@Service
public class TicketServiceImpl implements TicketService{

	Map<Integer, Ticket> map=new HashMap<>();
	@Override
	public Ticket bookTicket(Passanger p) {
		Ticket t=new Ticket();
		Random random = new Random();
        int id = random.nextInt(10);
		t.setTicketNumber(id);
		t.setStatus("Confirmed");
		
		BeanUtils.copyProperties(p, t);
		
		map.put(id, t);
		
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		return map.values();
	}

}
