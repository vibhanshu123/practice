package com.zest.parkinglot;

public class Level {

	private int floor;
	private ParkingSlot[] parkingSlots;
	private int availableSlots = 0;

	public Level(int floor, int numberOfSlots) {
		this.floor = floor;
		parkingSlots = new ParkingSlot[numberOfSlots];
		for (int i = 0; i < numberOfSlots; i++) {
			parkingSlots[i] = new ParkingSlot(this, i, VehicleSize.Car);
		}
		availableSlots = numberOfSlots;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		if (getAvailableslots() < vehicle.getSize().getSlotSize()) {
			return false;
		}
		int spotnumber = findAvailableSlots(vehicle);
		if (spotnumber < 0) {
			return false;
		}

		return parkStartingAtSlot(spotnumber, vehicle);
	}

	private int findAvailableSlots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSize().getSlotSize();
		int spotsFound = 0;
		int count = 0;
		for (ParkingSlot spot : parkingSlots) {
			if (spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return count - (spotsNeeded - 1);
			}
			count++;
		}
		return -1;
	}

	private boolean parkStartingAtSlot(int slotNumber, Vehicle vehicle) {
		//vehicle.clearspots();
		boolean success = true;
		for (int i = slotNumber; i < slotNumber + vehicle.size.getSlotSize(); i++) {
			success &= parkingSlots[i].park(vehicle);
		}
		availableSlots -= vehicle.getSize().getSlotSize();
		return success;
	}

	public int getAvailableslots() {
		return availableSlots;
	}

	public void spotFreed() {
		availableSlots++;
	}

	public Vehicle leaveVehicle(int slotNumber) {
		return parkingSlots[slotNumber].removeVehicle();
	}
	
	

}
