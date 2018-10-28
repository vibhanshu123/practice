package elevator;
public class GoToFloorCommand extends CommandBase {
	private int floor = 1;

	public GoToFloorCommand(Elevator lift, long time, boolean isExternal, int floor) {
		super(lift, time, isExternal);
		floor(floor);
	}

	public GoToFloorCommand(Elevator lift, long time, int floor) {
		super(lift, time);
		floor(floor);
	}

	protected void doIt() {
		Elevator elevator = elevator();
		int curr = elevator.floor();
		if (floor == curr) {
			System.out.println("Invalid GoToFloorCommand: Floor request is the same as current floor. Issue OpenDoorCommand instead.");
			return;
		}
		if (floor > curr) {
			elevator.enqueueFloorUpward(curr);
			return;
		}
		elevator.enqueueFloorDownward(curr);
	}

	public int floor() {
		return floor;
	}

	private void floor(int floor) {
		if (floor < 1) {
			System.out.println("floor must be greater than or equal to 1");
			throw new IllegalArgumentException();
		}
		this.floor = floor;
	}
}