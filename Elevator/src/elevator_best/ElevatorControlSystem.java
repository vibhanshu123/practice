package elevator_best;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorControlSystem {
	
	public static int time=0;
	private Queue<Elevator> freeElevators;
	private List<Elevator> elevators;
	private ElevatorScheduler scheduler;
	
	
	public ElevatorControlSystem(int numOfElevators,ElevatorScheduler scheduler) {
		this.scheduler=scheduler;
		elevators= new ArrayList<Elevator>();
		this.freeElevators=new LinkedList<Elevator>();
		for(int i=0;i<numOfElevators;i++) {
			elevators.add(new Elevator());
		}
		freeElevators.addAll(elevators);
		offerResources();
	}
	
	public void step() {
		offerResources();
		scheduler.schedule();
		elevators.forEach(Elevator::move);
		time++;
	}
	
	public void simulate() {
		while(scheduler.hasPendingRequests()||isServicingRequests()) {
			step();
		}
	}
	
	public void offerResources() {
		scheduler.addElevator(freeElevators.poll());
	}
	
	public void pickup(ElevatorRequest elevatorRequest) {
		scheduler.submit(elevatorRequest);
	}
	
	public boolean isServicingRequests() {
		for(Elevator e:elevators) {
			if(e.hasRequests()) return true; 
		}
		return false;
	}

	public List<RequestAllocation> history() {
		return scheduler.dump();
	}
	
	
	
	
	
	
	
	

}
