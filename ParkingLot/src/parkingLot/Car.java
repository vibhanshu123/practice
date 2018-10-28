package parkingLot;

public class Car extends Vehicle{
	
	public Car(){
		size=VehicleSize.Compact;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSpotsize()==VehicleSize.Compact|| spot.getSpotsize()==VehicleSize.Large;
		
	}

}
