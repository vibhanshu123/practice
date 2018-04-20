package states;

import robot.Robot;

public class West implements State{
	
		private Robot robot;
		
		
		public West(Robot robot) {
			this.robot = robot;
		}

		@Override
		public void turnleft() {
			robot.setState(robot.getSouth());
			
		}

		@Override
		public void turnright() {
			robot.setState(robot.getNorth());
			
		}

		@Override
		public void move() {
			int currentXPosition = robot.getPos().getX();
			if(currentXPosition>Robot.minX) {
				robot.getPos().setX(currentXPosition-1);
			}
		}
		
		@Override
		public String toString() {
			return "WEST";
			
		}

	}



