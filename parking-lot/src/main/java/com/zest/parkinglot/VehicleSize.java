package com.zest.parkinglot;

public enum VehicleSize {
     Motorcycle(1),Car(1),Bus(5);
	
	private int slotSize;
	private VehicleSize(int slotSize) {
		this.slotSize =slotSize;
	}
	public int getSlotSize() {
		return slotSize;
	}
	
	
}
