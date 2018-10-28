package parkingLot;

public class ParkingSpot {
	
	private VehicleSize spotsize;
	private Vehicle vehicle;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int i, VehicleSize size) {
	  level=lvl;
	  spotNumber=i;
	  spotsize = size;
	}

	public VehicleSize getSpotsize() {
		return spotsize;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public Level getLevel() {
		return level;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}

	public boolean park(Vehicle v) {
		if (!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}

}
