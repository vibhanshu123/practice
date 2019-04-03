package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;

public class VehicleNumberForColour implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private String colour;
    
	public VehicleNumberForColour(ParkingLot parkingLot, String colour) {
		this.parkingLot = parkingLot;
		this.colour = colour;
	}	
	
	public void executeCommand() {
		parkingLot.getVehicleNumberForColours(colour);
		
	}

}
