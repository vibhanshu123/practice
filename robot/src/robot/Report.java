package robot;

public class Report implements CommandToRobot{
	
	private Robot robot ;
    
	public Report(Robot robot) {
		this.robot = robot;
	}	
	
	@Override
	public void executeCommand() {
		robot.report();
		
	}

}
