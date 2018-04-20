package states;

import robot.Robot;

public class South implements State {

	private Robot robot;

	public South(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void turnleft() {
		robot.setState(robot.getEast());

	}

	@Override
	public void turnright() {
		robot.setState(robot.getWest());

	}

	@Override
	public void move() {
		int currentYPosition = robot.getPos().getY();
		if (currentYPosition > Robot.minY) {
			robot.getPos().setY(currentYPosition - 1);
		}
	}

	@Override
	public String toString() {
		return "SOUTH";

	}

}
