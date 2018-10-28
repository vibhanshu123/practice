package com.sc.test.car;

public class Left implements CommandToCar{
	
	private Car car ;
    
	public Left(Car car) {
		this.car = car;
	}	
	
	@Override
	public void executeCommand() {
		car.turnleft();
		
	}
}
