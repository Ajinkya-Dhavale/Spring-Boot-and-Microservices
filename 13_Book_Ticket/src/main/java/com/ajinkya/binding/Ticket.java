package com.ajinkya.binding;

public class Ticket {
	private Integer ticketNumber;
	private String name;
	private String email;
	private String to;
	private String from;
	private String dateOfJurney;
	private Integer trainNumber;
	private String status;
	public Integer getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getDateOfJurney() {
		return dateOfJurney;
	}
	public void setDateOfJurney(String dateOfJurney) {
		this.dateOfJurney = dateOfJurney;
	}
	public Integer getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", name=" + name + ", email=" + email + ", to=" + to + ", from="
				+ from + ", dateOfJurney=" + dateOfJurney + ", trainNumber=" + trainNumber + ", status=" + status + "]";
	}
	
	
}
