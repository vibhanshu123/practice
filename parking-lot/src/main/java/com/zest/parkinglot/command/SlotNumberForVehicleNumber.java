package com.zest.parkinglot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.ParkingLot;

public class SlotNumberForVehicleNumber implements CommandToParkingLot{
	
	private final Logger logger = LoggerFactory.getLogger(SlotNumberForVehicleNumber.class.getName());
	private ParkingLot parkingLot ;
	private String vehicleNumber;
    
	public SlotNumberForVehicleNumber(ParkingLot parkingLot, String vehicleNumber) {
		this.parkingLot = parkingLot;
		this.vehicleNumber = vehicleNumber;
	}	
	
	public void executeCommand() {
		int slotNumber = parkingLot.getSlotNumberForVehicleNumber(vehicleNumber);
		if (slotNumber > 0) {
			logger.info(Integer.toString(slotNumber));
		} else {
			logger.warn("Not Found");
		}
		
	}

}
