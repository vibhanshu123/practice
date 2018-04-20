package COMMANDDESIGNPatternUNDOButton;

public class LightOffCommand implements Command{

	Light light;
	int prevLevel;
	
	
	public LightOffCommand(Light light) {
		// TODO Auto-generated constructor stub
		 this.light=light;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		prevLevel=light.getLevel();
		light.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.dim(prevLevel);
	}

}
