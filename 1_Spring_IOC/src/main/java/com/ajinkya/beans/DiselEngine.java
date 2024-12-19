package com.ajinkya.beans;

public class DiselEngine implements IEngine {
	public DiselEngine() {
		System.out.println("Disel....");
	}

	@Override
	public boolean start() 
	{
		System.out.println("Disel Engine Started....");
		return true;
	}

}
