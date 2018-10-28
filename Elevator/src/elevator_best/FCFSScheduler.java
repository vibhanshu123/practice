package elevator_best;

import java.util.LinkedList;
import java.util.Queue;

public class FCFSScheduler extends ElevatorScheduler{
	
	Queue<ElevatorRequest> waitingQueue ;
	int next=0;
	
	public FCFSScheduler() {
		waitingQueue=new LinkedList<>();
	}

	@Override
	public void submit(ElevatorRequest elevatorRequest) {
		waitingQueue.add(elevatorRequest);
		
	}

	@Override
	public boolean hasPendingRequests() {
		return waitingQueue.size()>0;
	}

	@Override
	public void schedule() {
		while(hasPendingRequests()) {
			Elevator e= elevators.get(next);
			ElevatorRequest er = waitingQueue.poll();
			e.addRequest(er);
			logAlloc(e, er);
			next=(next+1)%elevators.size();
		}
		
	}

}
