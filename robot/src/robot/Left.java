package robot;

public class Left implements CommandToRobot{
	
	private Robot robot ;
    
	public Left(Robot robot) {
		this.robot = robot;
	}	
	
	@Override
	public void executeCommand() {
		robot.turnleft();
		
	}

}
