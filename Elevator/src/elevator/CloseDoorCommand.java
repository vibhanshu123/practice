package elevator;
public class CloseDoorCommand extends CommandBase {

	public CloseDoorCommand(Elevator lift, long time, boolean isExternal) {
		super(lift, time, isExternal);
	}
	
	public CloseDoorCommand(Elevator lift, long time) {
		super(lift, time);
	}

	protected void doIt() {
		Elevator elevator = elevator();
		if (elevator.isDoorOpen()) {
			elevator.closeDoor();
		}
	}
}