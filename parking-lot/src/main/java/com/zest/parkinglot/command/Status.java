package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;

public class Status implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
    
	public Status(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}	
	
	public void executeCommand() {
		parkingLot.report();
	}

}
