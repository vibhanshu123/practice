package elevator;
public abstract class CommandBase {
	private Elevator elevator = null;
	private long time = 0;
	private boolean isExternal = false;
	
	public CommandBase(Elevator elevator, long time, boolean isExternal) {
		this(elevator, time);
		isExternal(isExternal);
	}
	
	public CommandBase(Elevator elevator, long time) {
		elevator(elevator);
		time(time);
	}

	public void execute() {
		if (isIllegalOperation()) {
			System.out.println("Illegal operation: command aborted");
			return;
		}
		doIt();
	}

	abstract protected void doIt();

	public Elevator elevator() {
		return elevator;
	}

	public void elevator(Elevator elevator) {
		if (elevator == null) {
			System.out.println("Elevator must not be null");
			throw new IllegalArgumentException();
		}
		this.elevator = elevator;
	}

	public long time() {
		return time;
	}

	public void time(long time) {
		if (time < 0) {
			System.out.println("time must be greater than or equal to zero");
			throw new IllegalArgumentException();
		}
		this.time = time;
	}

	public boolean isExternal() {
		return isExternal;
	}

	public void isExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}

	private boolean isIllegalOperation() {
		if (isExternal && elevator.isMaintenanceState()) {
			System.out.println("A Elevator does not accept external commands in MAINTENANCE state.");
			return true;
		}
		return false;
	}

}