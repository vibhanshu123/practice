package com.sc.test.car;

public class Move implements CommandToCar{
	
	private Car car ;
    
	public Move(Car car) {
		this.car = car;
	}	
	
	@Override
	public void executeCommand() {
		car.move();
		
	}

}
