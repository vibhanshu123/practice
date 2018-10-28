package parkingLot;

public class Bike extends Vehicle{
	
	public Bike() {
		size=VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
		
	}

}
