package robot;

public class Move implements CommandToRobot{
	
	private Robot robot ;
    
	public Move(Robot robot) {
		this.robot = robot;
	}	
	
	@Override
	public void executeCommand() {
		robot.move();
		
	}

}
