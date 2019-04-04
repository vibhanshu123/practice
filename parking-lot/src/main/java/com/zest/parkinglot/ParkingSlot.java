package com.zest.parkinglot;

public class ParkingSlot {
	
	private VehicleSize slotsize;
	private Vehicle vehicle;
	private int slotNumber;
	private Level level;

	public ParkingSlot(Level lvl, int i, VehicleSize size) {
	  level=lvl;
	  slotNumber=i;
	  slotsize = size;
	}

	public VehicleSize getSlotsize() {
		return slotsize;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public Level getLevel() {
		return level;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSlot(this);
	}

	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSlot(this);
		return true;
	}
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}

	@Override
	public String toString() {
		return (slotNumber+1) +" "+vehicle.getVehiclenumber()+" "+vehicle.getColour()  ;
	}
	
	

}
