package robot;

public class Right implements CommandToRobot{
	
	private Robot robot ;
    
	public Right(Robot robot) {
		this.robot = robot;
	}	
	
	@Override
	public void executeCommand() {
		robot.turnright();
		
	}

}
