package com.zest.parkinglot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingLot {
	
    private final Logger logger = LoggerFactory.getLogger(ParkingLot.class.getName());
	private Level[] levels;
	private final int NUM_LEVELS;

	public ParkingLot(int numOfLevels, int numberOfSlots) {
		this.NUM_LEVELS = numOfLevels;
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, numberOfSlots);
		}
		logger.info("Created a parking lot with "+numberOfSlots+" slots");

	}

	public void parkVehicle(Vehicle vehicle) {
		int slotNumber = -1;
		for (int i = 0; i < levels.length; i++) {
			slotNumber = levels[i].parkVehicle(vehicle);
			if (slotNumber > 0)
				break;
		}
		if (slotNumber < 0) {
			logger.error("Sorry, parking lot is full");
		} else {
			logger.info("Allocated slot number: " + (slotNumber+1));
		}
	}

	public void leaveVehicle(int slotNumber) {
		levels[0].leaveVehicle((slotNumber-1)) ;
		logger.info("Slot number "+slotNumber +" is free");
		
	}

	public void report() {
		Arrays.asList(levels[0].getParkingSlots()).stream()
		.filter(t -> !t.isAvailable())
		.forEach(t -> logger.info(t.toString()));
	}

	public void getVehicleNumberForColours(String colour) {
		List<Vehicle> vehicles = Arrays.asList(levels[0].getParkingSlots()).stream()
				.filter(t -> !t.isAvailable())
				.map(t -> t.getVehicle())
				.filter(t -> t.getColour().equalsIgnoreCase(colour))
				.collect(Collectors.toList());
		if (vehicles.size() > 0) {
			String vehicle = vehicles.stream()
					.map(v -> v.getVehiclenumber())
					.collect(Collectors.joining(","));
			logger.info(vehicle);
		} else {
			logger.warn("Not Found");
		}
	}

	public void getSlotNumberForColour(String colour) {
		List<Vehicle> vehicles = Arrays.asList(levels[0].getParkingSlots()).stream()
				.filter(t -> !t.isAvailable())
				.map(t -> t.getVehicle())
				.filter(t -> t.getColour().equalsIgnoreCase(colour))
				.collect(Collectors.toList());
		if (vehicles.size() > 0) {
			String slots = vehicles.stream()
					.map(v -> Integer.toString(v.getSlotNumber()+1))
					.collect(Collectors.joining(","));
			logger.info(slots);
		} else {
			logger.warn("Not Found");
		}

	}

	public void getSlotNumberForVehicleNumber(String vehicleNumber) {
		List<Vehicle> vehicles = Arrays.asList(levels[0].getParkingSlots()).stream()
				.filter(t -> !t.isAvailable())
				.map(t -> t.getVehicle())
				.filter(t -> t.getVehiclenumber().equalsIgnoreCase(vehicleNumber))
				.collect(Collectors.toList());
		if (vehicles.size() > 0) {
			logger.info(Integer.toString(vehicles.get(0).getSlotNumber()+1));
		} else {
			logger.warn("Not Found");
		}

	}

}
