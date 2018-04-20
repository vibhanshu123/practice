package COMMANDDESIGNPatternRemote;

public class LightsOnCommand implements Command{
	
	Light light;
	
	public LightsOnCommand(Light light){
		this.light=light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.lightOn();
	}

}
