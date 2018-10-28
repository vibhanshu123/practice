package com.sc.test.car;

public class Right implements CommandToCar{
	
	private Car car ;
    
	public Right(Car car) {
		this.car = car;
	}	
	
	@Override
	public void executeCommand() {
		car.turnright();
		
	}

}
