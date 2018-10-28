package elevator;
public class OpenDoorCommand extends CommandBase {

	public OpenDoorCommand(Elevator lift, long time, boolean isExternal) {
		super(lift, time, isExternal);
	}
	
	public OpenDoorCommand(Elevator lift, long time) {
		super(lift, time);
	}

	protected void doIt() {
		Elevator elevator = elevator();
		if (!elevator.isDoorOpen()) {
			elevator.openDoor();
		}
	}
}