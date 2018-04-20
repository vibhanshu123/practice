package COMMANDDESIGNPattern;

public class LightsOffCommand implements Command{

	Light light;
	
	public LightsOffCommand(Light light) {
		this.light=light;
	}
	
	@Override
	public void execute() {
		light.lightOff();
		
	}

}
