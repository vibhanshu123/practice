package com.zest.parkinglot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.ParkingLot;

public class VehicleNumberForColour implements CommandToParkingLot {

	private final Logger logger = LoggerFactory.getLogger(VehicleNumberForColour.class.getName());
	private ParkingLot parkingLot;
	private String colour;

	public VehicleNumberForColour(ParkingLot parkingLot, String colour) {
		this.parkingLot = parkingLot;
		this.colour = colour;
	}

	public void executeCommand() {
		String vehicle = parkingLot.getVehicleNumberForColours(colour);
		if (vehicle != null) {
			logger.info(vehicle);
		} else {
			logger.warn("Not Found");
		}
	}

}
