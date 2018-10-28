package parkingLot;

public class Level {
	
	private int floor;
	private ParkingSpot[] parkingspots;
	private int availablespots=0;
	

	public Level(int floor, int numberOfSpots) {
		this.floor=floor;
		parkingspots = new ParkingSpot[numberOfSpots];
		int largespots= numberOfSpots/4;
		int bikespots = numberOfSpots/4;
		int compactspots= numberOfSpots-largespots-bikespots;
		for(int i=0;i<numberOfSpots;i++) {
			VehicleSize size = VehicleSize.Motorcycle;
			if(i<largespots) {
				size=VehicleSize.Large;
			}else if(i<largespots+compactspots) {
				size=VehicleSize.Compact;
			}
			parkingspots[i]=new ParkingSpot(this,i,size);
		}
		availablespots=numberOfSpots;
		}

	public boolean parkVehicle(Vehicle vehicle) {
		if(getAvailablespots()<vehicle.getSize().getSpotSize()) {
			return false;
		}
		int spotnumber=findAvailableSpots(vehicle);
		if(spotnumber<0) {
			return false;
		}
		
		return parkStartingAtSpot(spotnumber,vehicle);
	}
	
	private int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSize().getSpotSize();
		int spotsFound = 0;
		int count=0;
		for (ParkingSpot spot :parkingspots) {
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

	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
		//vehicle.clearspots();
		boolean success = true;
		for (int i = spotNumber; i < spotNumber + vehicle.size.getSpotSize(); i++) {
			 success &= parkingspots[i].park(vehicle);
		}
		availablespots -= vehicle.getSize().getSpotSize();
		return success;
	}


	public int getAvailablespots() {
		return availablespots;
	}

	public void spotFreed() {
		availablespots++;
		
	}
	
	

}
