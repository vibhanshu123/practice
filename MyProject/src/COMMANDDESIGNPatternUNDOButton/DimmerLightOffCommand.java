package COMMANDDESIGNPatternUNDOButton;

public class DimmerLightOffCommand implements Command{
	
	Light light;
	int prevLevel;
	
	public DimmerLightOffCommand(Light light) {
		// TODO Auto-generated constructor stub
		this.light=light;
		prevLevel=100;
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
