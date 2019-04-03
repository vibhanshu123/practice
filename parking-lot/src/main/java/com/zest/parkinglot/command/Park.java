package com.zest.parkinglot.command;

import com.zest.parkinglot.ParkingLot;
import com.zest.parkinglot.Vehicle;

public class Park implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private Vehicle vehicle ;
    
	public Park(ParkingLot parkingLot, Vehicle vehicle) {
		this.parkingLot = parkingLot;
		this.vehicle = vehicle;
	}	
	
	public void executeCommand() {
		parkingLot.parkVehicle(vehicle);
	}

}
