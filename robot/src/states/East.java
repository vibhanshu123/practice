package states;

import robot.Robot;

public class East implements State{
	private Robot robot;
	
	
	public East(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void turnleft() {
		robot.setState(robot.getNorth());
		
	}

	@Override
	public void turnright() {
		robot.setState(robot.getSouth());
	}

	@Override
	public void move() {
		int currentXPosition = robot.getPos().getX();
		if(currentXPosition<Robot.maxX) {
			robot.getPos().setX(currentXPosition+1);
		}
	}
	
	@Override
	public String toString() {
		return "EAST";
		
	}
	
		

}
