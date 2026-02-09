package com.ajinkya.beans;

public class PetrolEngine implements IEngine{

	public PetrolEngine() {
		System.out.println("Petrol....");
	}
	@Override
	public boolean start() {
		System.out.println("Pretrol Engine is Started...");
		return true;
	}

}
