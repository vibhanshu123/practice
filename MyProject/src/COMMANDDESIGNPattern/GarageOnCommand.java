package COMMANDDESIGNPattern;

public class GarageOnCommand implements Command{
	
	GarageDoor garageDoor;
	
	public GarageOnCommand(GarageDoor garageDoor){
		this.garageDoor=garageDoor;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garageDoor.up();
		
		
	}

}
