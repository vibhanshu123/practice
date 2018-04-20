package COMMANDDESIGNPatternRemote;

public class HotTubOffCommand implements Command{

	Hottub hottub;
	
	public HotTubOffCommand(Hottub hottub) {
		// TODO Auto-generated constructor stub
		this.hottub=hottub;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		hottub.cool();
		hottub.off();
		
	}

	
	
}
