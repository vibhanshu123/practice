package COMMANDDESIGNPatternRemote;

public class HotTubOnCommand implements Command{

	Hottub hottub;
	
	public HotTubOnCommand(Hottub hottub) {
		// TODO Auto-generated constructor stub
		this.hottub=hottub;
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
	  hottub.on();
	  hottub.heat();
	  hottub.bubblesOn();
	}

}
