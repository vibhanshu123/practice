package elevator_best;
public class RequestAllocation {
    private final int time;
    private final Elevator elevator;
    private final ElevatorRequest req;

    public RequestAllocation(int time, Elevator elevator, ElevatorRequest req) {
        this.time = time;
        this.elevator = elevator;
        this.req = req;
    }

    public String toString() {
        return String.format("[elevator: %s, req: %s]", elevator, req);
    }
}