package COMMANDDESIGNPatternRemote;

public class LivingroomLightOnCommand implements Command {
	Light light;

	public LivingroomLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.lightOn();
	}
}
