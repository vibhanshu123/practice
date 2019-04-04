package com.zest.parkinglot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.ParkingLot;
import com.zest.parkinglot.Vehicle;

public class Park implements CommandToParkingLot{
	
	private final Logger logger = LoggerFactory.getLogger(Park.class.getName());
	private ParkingLot parkingLot ;
	private Vehicle vehicle ;	
    
	public Park(ParkingLot parkingLot, Vehicle vehicle) {
		this.parkingLot = parkingLot;
		this.vehicle = vehicle;
	}	
	
	public void executeCommand() {
		int slotNumber=parkingLot.parkVehicle(vehicle);
		if (slotNumber == 0) {
			logger.error("Sorry, parking lot is full");
		} else {
			logger.info("Allocated slot number: " + slotNumber);
		}
	}

}
