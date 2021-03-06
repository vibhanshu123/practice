package COMMANDDESIGNPatternUNDOButton;

public class DimmerLightOnCommand implements Command{

	Light light;
	int prevLevel;
	
	public DimmerLightOnCommand(Light light) {
		// TODO Auto-generated constructor stub
		this.light=light;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		prevLevel=light.getLevel();
		light.dim(75);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		light.dim(prevLevel);
	}

}
