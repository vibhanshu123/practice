package elevator_best;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class ElevatorScheduler {
	
	List<Elevator> elevators;
	List<RequestAllocation> reqAlloc;
	
	public ElevatorScheduler() {
		this.elevators=new ArrayList<>();
		reqAlloc= new LinkedList<>();
	}
	
	public abstract void submit(ElevatorRequest elevatorRequest);
	public abstract boolean hasPendingRequests();
	public abstract void schedule();
	
    public void addElevator(Elevator e) {
    	   elevators.add(e);
    }
    
    public void logAlloc(Elevator elevator, ElevatorRequest req) {
        reqAlloc.add(new RequestAllocation(ElevatorControlSystem.time, elevator, req));
    }


	public List<RequestAllocation> dump() {
		return reqAlloc;
	}
    

}
