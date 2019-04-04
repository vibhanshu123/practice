package com.zest.parkinglot.command;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zest.parkinglot.ParkingLot;
import com.zest.parkinglot.ParkingSlot;

public class Status implements CommandToParkingLot{
	
	private ParkingLot parkingLot ;
	private final Logger logger = LoggerFactory.getLogger(Status.class.getName());

    
	public Status(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}	
	
	public void executeCommand() {
		List<ParkingSlot> parkingSlots=parkingLot.report();
		parkingSlots.stream().forEach(t->logger.info(t.toString()));
	}

}
