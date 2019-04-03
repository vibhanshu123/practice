package com.zest.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	private final String vehicleNumber;
	private final String colour;
	private List<ParkingSlot> parkingSlots = null;
	protected VehicleSize size;

	public Vehicle(String vehicleNumber, String colour) {
		this.vehicleNumber = vehicleNumber;
		this.colour = colour;
		parkingSlots = new ArrayList<ParkingSlot>();
	}

	public String getVehiclenumber() {
		return vehicleNumber;
	}

	public VehicleSize getSize() {
		return size;
	}
    
	public String getColour() {
		return colour;
	}

	public void parkInSlot(ParkingSlot parkingSlot) {
		parkingSlots.add(parkingSlot);
	}
	
	public void clearSpots() {
		for (ParkingSlot slot : parkingSlots) {
			slot.removeVehicle();
		}
		parkingSlots.clear();
	}

	public abstract boolean canFitInSlot(ParkingSlot slot);
}
