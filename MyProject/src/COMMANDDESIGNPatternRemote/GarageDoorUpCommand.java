package COMMANDDESIGNPatternRemote;

public class GarageDoorUpCommand implements Command{
	
	GarageDoor garageDoor;
	
	public GarageDoorUpCommand(GarageDoor garageDoor) {
		// TODO Auto-generated constructor stub
		this.garageDoor=garageDoor;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garageDoor.up();
	}

}
