package elevator_best;

public class ElevatorRequest {
	
	private enum RequestStatus{waiting,completed};
	private int startFloor;
	private int endFloor;
	private RequestStatus currentStatus;
	private int id;
	
	public ElevatorRequest(int startFloor, int endFloor) {
		this.id=hashCode();
		this.startFloor=startFloor;
		this.endFloor=endFloor;
		this.currentStatus=RequestStatus.waiting;
				
	}

	public int getStartFloor() {
		return startFloor;
	}

	public int getEndFloor() {
		return endFloor;
	}

	public RequestStatus getCurrentStatus() {
		return currentStatus;
	}
	
	public boolean isUp() {
		return (startFloor<endFloor);
	}
	
	public boolean isDown() {
		return !isUp();
	}
	
	public void finish() {
		currentStatus=RequestStatus.completed;
	}
	
	 public String toString() {
	        return String.format("[%d: %d -> %d]", id, startFloor, endFloor);
	    }

	

}
