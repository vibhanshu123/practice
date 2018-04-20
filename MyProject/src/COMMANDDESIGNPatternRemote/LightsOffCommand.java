package COMMANDDESIGNPatternRemote;

public class LightsOffCommand implements Command{

    Light light;
	
	public LightsOffCommand(Light light){
		this.light=light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.lightOff();
	}
	
}
