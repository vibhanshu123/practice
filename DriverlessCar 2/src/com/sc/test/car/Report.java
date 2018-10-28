package com.sc.test.car;

public class Report implements CommandToCar{
	
	private Car car ;
    
	public Report(Car car) {
		this.car = car;
	}	
	
	@Override
	public void executeCommand() {
		car.report();
	}

}
