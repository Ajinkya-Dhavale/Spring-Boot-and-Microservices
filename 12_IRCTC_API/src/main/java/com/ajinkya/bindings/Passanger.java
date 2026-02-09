package com.ajinkya.bindings;

public class Passanger {
	private String name;
	private String email;
	private String to;
	private String from;
	private String dateOfJurney;
	private Integer trainNumber;
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
	@Override
	public String toString() {
		return "Passanger [name=" + name + ", email=" + email + ", to=" + to + ", from=" + from + ", dateOfJurney="
				+ dateOfJurney + ", trainNumber=" + trainNumber + "]";
	}
	
	
}
