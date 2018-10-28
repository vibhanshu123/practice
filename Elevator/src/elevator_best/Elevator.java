package elevator_best;

import java.util.LinkedList;
import java.util.Queue;

import elevator.ElevatorState;


public class Elevator {
	
	private enum Direction{UP,DOWN,STATIONARY};
	private enum State{IDLE,OCCUPIED,PICKUP};
	
	private Queue<ElevatorRequest> requests;
	private int id;
	private Direction direction;
	private State currentstate;
	private ElevatorRequest currentReqest;
	private int currentFloor;
	private int targetFloor;
	
	Elevator(){
		this.id=hashCode();
		this.currentFloor =0;
		this.targetFloor = 0;
		requests= new LinkedList<>();
		this.currentstate=State.IDLE; 
		this.direction=Direction.STATIONARY;
	}

	public Direction getDirection() {
		return direction;
	}

	public State getCurrentstate() {
		return currentstate;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}
	

	public void stop() {
		direction=Direction.STATIONARY;
		currentstate=State.IDLE;
	}
	
	public void move() {
		System.out.println(this);

		if (currentReqest == null && requests.isEmpty()) {
			stop();
			return;
		}

		if (currentReqest == null) {
			currentReqest = requests.poll();

			if (currentFloor != currentReqest.getStartFloor()) {
				currentstate = State.PICKUP;
				targetFloor = currentReqest.getStartFloor();
			} else {
				currentstate = State.OCCUPIED;
				targetFloor = currentReqest.getEndFloor();
			}
		}

		if (currentFloor == targetFloor) {
			if (currentstate.equals(State.OCCUPIED)) {
				currentReqest.finish();
				currentReqest = null;
			} else {
				targetFloor = currentReqest.getEndFloor();
				currentstate = State.OCCUPIED;
			}
		} else if (currentFloor < targetFloor) {
			up();
		} else if (currentFloor > targetFloor) {
			down();
		}

	}
	
	
	public void movenew() {
		if (currentReqest == null && requests.size() == 0) {
			return;
		}
		if (currentReqest == null) {
			currentReqest = requests.poll();
			if (currentReqest.getStartFloor() == currentFloor) {
				currentstate = State.OCCUPIED;
				targetFloor = currentReqest.getEndFloor();
			} else {
				currentstate = State.PICKUP;
				targetFloor = currentReqest.getStartFloor();
			}
		}
		
		if (targetFloor == currentFloor) {
			if (currentstate.equals(State.OCCUPIED)) {
				currentstate = State.IDLE;
				currentReqest.finish();
				currentReqest = null;
			} else {
				currentstate = State.OCCUPIED;
				targetFloor = currentReqest.getEndFloor();
			}
		} else if (currentFloor < targetFloor) {
			up();
		} else if (currentFloor > targetFloor) {
			down();
		}
	}
	
	public void up() {
		currentFloor++;
		direction=Direction.UP;
		
	}
	
	public void down() {
		currentFloor--;
		direction=Direction.DOWN;
	}
	
	public void addRequest(ElevatorRequest request) {
		this.requests.add(request);
	}

	public boolean hasRequests() {
		return this.requests.size() > 0 || this.currentReqest != null;
	}
	
	public String toString() {
		return String.format("elevator(id: %d, floor: %d, dir: %s, status: %s)", id, currentFloor, direction, currentstate);
	}
		
}
