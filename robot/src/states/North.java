package states;

import robot.Direction;
import robot.Robot;

public class North implements State {

	private Robot robot;

	public North(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void turnleft() {
		robot.setState(robot.getWest());

	}

	@Override
	public void turnright() {
		robot.setState(robot.getEast());

	}

	@Override
	public void move() {
		int currentYPosition = robot.getPos().getY();
		if(currentYPosition<Robot.maxY) {
			robot.getPos().setY(currentYPosition+1);
		}
	}
	
	@Override
	public String toString() {
		return "NORTH";
		
	}

}
