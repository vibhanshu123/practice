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

	public int parkVehicle(Vehicle vehicle) {
		if (getAvailableslots() < vehicle.getSize().getSlotSize()) {
			return -1;
		}
		int slotNumber = findAvailableSlots(vehicle);
		if (slotNumber < 0) {
			return -1;
		}
		if(parkStartingAtSlot(slotNumber, vehicle))
			return slotNumber;
		else 
			return -1;
	}

	private int findAvailableSlots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSize().getSlotSize();
		int slotsFound = 0;
		int count = 0;
		for (ParkingSlot slot : parkingSlots) {
			if (slot.canFitVehicle(vehicle)) {
				slotsFound++;
			} else {
				slotsFound = 0;
			}
			if (slotsFound == spotsNeeded) {
				return count - (spotsNeeded - 1);
			}
			count++;
		}
		return -1;
	}

	private boolean parkStartingAtSlot(int slotNumber, Vehicle vehicle) {
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

	public void leaveVehicle(int slotNumber) {
		parkingSlots[slotNumber].removeVehicle();
	}

	public ParkingSlot[] getParkingSlots() {
		return parkingSlots;
	}
	

}
