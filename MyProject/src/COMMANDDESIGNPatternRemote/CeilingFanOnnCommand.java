package COMMANDDESIGNPatternRemote;

public class CeilingFanOnnCommand implements Command{
	
	CeilingFan ceilingFan;
	
	public CeilingFanOnnCommand(CeilingFan ceilingFan) {
		// TODO Auto-generated constructor stub
		this.ceilingFan=ceilingFan;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
       ceilingFan.high();		
	}

}
