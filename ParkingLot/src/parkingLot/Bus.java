package parkingLot;

public class Bus extends Vehicle{
	
	public Bus() {
		size=VehicleSize.Large;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotsize()==VehicleSize.Large;
		
	}

}
