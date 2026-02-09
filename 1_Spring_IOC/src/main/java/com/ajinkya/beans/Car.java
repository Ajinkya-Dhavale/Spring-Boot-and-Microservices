package com.ajinkya.beans;

public class Car {
	private IEngine engine;
	public Car() {
		System.out.println("Car.....");
	}
	public void setEng(IEngine engine) {
		this.engine=engine;
	}
	void drive() {
		boolean status=engine.start();
		
		if(status)
		{
			System.out.println("Car is Started......");
		}
		else {
			System.out.println("Error....");
		}
	}
}
