package COMMANDDESIGNPatternUNDOButton;

public class RemoteControlWithUndo {
	
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControlWithUndo() {
		// TODO Auto-generated constructor stub
		onCommands=new Command[7];
		offCommands=new Command[7];
		
		Command noCommand=new NoCommand();
		for(int i=0;i<7;i++){
			onCommands[i]=noCommand;
			offCommands[i]=noCommand;
		}
		
		undoCommand=noCommand;
	}
	
	public void setCommand(int slot,Command onCommand,Command offCommand){
		onCommands[slot]=onCommand;
		offCommands[slot]=offCommand;		
	}
	
	public void onButtonWasPushed(int slot){
		onCommands[slot].execute();
		undoCommand=onCommands[slot];
	}
	
	public void offButtonWasPushed(int slot){
		offCommands[slot].execute();
		undoCommand=offCommands[slot];
	}
	
    public void undoButtonWasPushed(){
    	undoCommand.undo();
    }
	
	public String toString(){
	 StringBuffer buffer=new StringBuffer();
	 buffer.append("\n--------Remote Control --------\n");
	 
	 	for(int i=0;i<7;i++){
			buffer.append("slot[ "+i+" ]  "+onCommands[i].getClass().getName()+" ");
			buffer.append("slot["+i+"]"+offCommands[i].getClass().getName()+"\n");
		}
	 	buffer.append("[undo] "+undoCommand.getClass().getName()+"\n");
	  return buffer.toString();	
	}
	
	
	
	

}
