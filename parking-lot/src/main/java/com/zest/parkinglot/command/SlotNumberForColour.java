package com.zest.parkinglot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.ParkingLot;

public class SlotNumberForColour implements CommandToParkingLot{
	
	private final Logger logger = LoggerFactory.getLogger(SlotNumberForColour.class.getName());
	private ParkingLot parkingLot ;
	private String colour;
    
	public SlotNumberForColour(ParkingLot parkingLot, String colour) {
		this.parkingLot = parkingLot;
		this.colour = colour;
	}	
	
	public void executeCommand() {
		String slots=parkingLot.getSlotNumberForColour(colour);
		if (slots != null) {
			logger.info(slots);
		} else {
			logger.warn("Not Found");
		}
		
	}

}
