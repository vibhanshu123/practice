package elevator;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {

	private int minFloor = ElevatorConstants.MIN_FLOOR;
	private int maxFloor = ElevatorConstants.MAX_FLOOR;
	private int floor = minFloor;
	private int load = 0;
	private int maxLoad = ElevatorConstants.MAX_LOAD;
	private ElevatorState currentState = ElevatorState.STATIONARY;
	private boolean isDoorOpen = false;
	private String id = null;
	private Queue<Integer> upHeap = new PriorityQueue<>(maxFloor);
	private Queue<Integer> downHeap = new PriorityQueue<>(maxFloor, Collections.reverseOrder());
	
	
	private Elevator(String id, int maxFloor, int minFloor, int maxLoad) {
		this(id, maxFloor, minFloor);
		maxLoad(maxLoad);
	}
	
	private Elevator(String id, int maxFloor, int minFloor) {
		this(id, maxFloor);
		minFloor(minFloor);
		floor(minFloor);
	}
	
	private Elevator(String id, int maxFloor) {
		id(id);
		maxFloor(maxFloor);
	}
	
	protected void floor(int floor) {
		if (floor < minFloor) {
			System.out.println(
					"current floor must not be less than minFloor\nfloor [{}]\nminFloor [{}]"+
					floor+ minFloor);
			throw new IllegalArgumentException();
		}
		if (floor > maxFloor) {
			System.out.println(
					"current floor must not be greater than maxFloor\nfloor [{}]\nmaxFloor [{}]"+
					floor+ maxFloor);
			throw new IllegalArgumentException();
		}
		this.floor = floor;
	}
	

	protected String id() {
		return id;
	}
	
	private void id(String id) {
		if (id == null || id.isEmpty()) {
			System.out.println("id must not be null or empty string");
			throw new IllegalArgumentException();
		}
		this.id = id;
	}
	
	protected void maxFloor(int maxFloor) {
		if (maxFloor < 1) {
			System.out.println("maxFloor must be greater than or equal to 1");
			throw new IllegalArgumentException();
		}
		if (maxFloor < minFloor) {
			System.out.println("maxFloor must be greater than or equal to minFloor");
			throw new IllegalArgumentException();
		}
		this.maxFloor = maxFloor;
	}
	
	protected void maxLoad(int maxLoad) {
		if (maxLoad < 1000) {
			System.out.println("maxLoad must be greater than or equal to 1000 kg");
			throw new IllegalArgumentException();
		}
		this.maxLoad = maxLoad;
	}
	
	protected void minFloor(int minFloor) {
		if (minFloor < 1) {
			System.out.println("minFloor must be greater than or equal to 1");
			throw new IllegalArgumentException();
		}
		if (minFloor > maxFloor) {
			System.out.println("minFloor must be less than or equal to maxFloor");
			throw new IllegalArgumentException();
		}
		this.minFloor = minFloor;
	}


	
}
