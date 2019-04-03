package com.zest.parkinglot;

public class Car extends Vehicle{
	
	public Car(String vehicleNumber, String colour){
		super(vehicleNumber, colour);
		this.size=VehicleSize.Car;
	}

	@Override
	public boolean canFitInSlot(ParkingSlot spot) {
		return spot.getSlotsize()==VehicleSize.Car|| spot.getSlotsize()==VehicleSize.Bus;
		
	}

}
