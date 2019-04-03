package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;

public class Leave implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private int slotNumber;
    
	public Leave(ParkingLot parkingLot, int slotNumber) {
		this.parkingLot = parkingLot;
		this.slotNumber = slotNumber ;
	}	
	
	public void executeCommand() {
		parkingLot.leaveVehicle(slotNumber);
		
	}

}
