package com.zest.parkinglot;

public class ParkingLot {

	private Level[] levels;
	private final int NUM_LEVELS;

	public ParkingLot(int numOfLevels, int numberOfSpots) {
		this.NUM_LEVELS = numOfLevels;
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, numberOfSpots);
		}

	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}

	public boolean leaveVehicle(int slotNumber) {
		return false;
	}

	public void report() {
		// TODO Auto-generated method stub

	}

	public void getVehicleNumberForColours(String colour) {
		// TODO Auto-generated method stub

	}

	public void getSlotNumberForColour(String colour) {
		// TODO Auto-generated method stub

	}

	public void getSlotNumberForVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub

	}

}
