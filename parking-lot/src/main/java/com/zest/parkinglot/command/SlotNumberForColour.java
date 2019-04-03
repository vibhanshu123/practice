package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;

public class SlotNumberForColour implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private String colour;
    
	public SlotNumberForColour(ParkingLot parkingLot, String colour) {
		this.parkingLot = parkingLot;
		this.colour = colour;
	}	
	
	public void executeCommand() {
		parkingLot.getSlotNumberForColour(colour);
		
	}

}
