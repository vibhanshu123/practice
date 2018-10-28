package parkingLot;

public enum VehicleSize {
     Motorcycle(1),Compact(1),Large(5);
	
	private int spotSize;
	private VehicleSize(int spotSize) {
		this.spotSize =spotSize;
	}
	public int getSpotSize() {
		return spotSize;
	}
	
	
}
