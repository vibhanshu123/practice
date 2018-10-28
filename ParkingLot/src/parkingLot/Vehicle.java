package parkingLot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	protected String vehiclenumber;
	List<ParkingSpot> parkingspots = new ArrayList<ParkingSpot>();
	protected VehicleSize size;
	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public VehicleSize getSize() {
		return size;
	}
	
	public void clearSpots() {
	for (ParkingSpot spot:parkingspots) {
		spot.removeVehicle();
	}
	parkingspots.clear();
}
	
	public void parkInSpot(ParkingSpot parkingSpot) {
		parkingspots.add(parkingSpot);
	}
    
	public abstract boolean canFitInSpot(ParkingSpot spot);
}
