package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;

public class SlotNumberForVehicleNumber implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private String vehicleNumber;
    
	public SlotNumberForVehicleNumber(ParkingLot parkingLot, String vehicleNumber) {
		this.parkingLot = parkingLot;
		this.vehicleNumber = vehicleNumber;
	}	
	
	public void executeCommand() {
		parkingLot.getSlotNumberForVehicleNumber(vehicleNumber);
		
	}

}
