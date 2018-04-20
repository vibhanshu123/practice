package COMMANDDESIGNPatternUNDOButton;

public class LightOnCommand implements Command{
    
	Light light;
	int prevLevel;
	
	public LightOnCommand(Light light) {
		// TODO Auto-generated constructor stub
		this.light=light;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
	  prevLevel=light.getLevel();	
	  light.on();	
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
     light.dim(prevLevel);		
	}

}
