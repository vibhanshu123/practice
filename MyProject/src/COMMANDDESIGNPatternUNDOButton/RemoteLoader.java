package COMMANDDESIGNPatternUNDOButton;

import COMMANDDESIGNPatternRemote.CeilingFanOnnCommand;

public class RemoteLoader {
	
	public static void main(String[] args){
	
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
//	
//	Light livingRoomLight= new Light("Living Room");
//	
//	LightOnCommand lightOnCommand= new LightOnCommand(livingRoomLight);
//	LightOffCommand lighOffCommand = new LightOffCommand(livingRoomLight);
//	remoteControl.setCommand(0, lightOnCommand, lighOffCommand);
//	
//	//System.out.println(remoteControl);
//	remoteControl.onButtonWasPushed(0);
//	remoteControl.offButtonWasPushed(0);
//	remoteControl.undoButtonWasPushed();
//	System.out.println(remoteControl);
//	remoteControl.offButtonWasPushed(0);
//	remoteControl.onButtonWasPushed(0);
//	remoteControl.undoButtonWasPushed();
//	
//	System.out.println(remoteControl);
//	
//	CeilingFan ceilingFan = new CeilingFan("livingRoom");
//	CeilingFanHighCommand cFanHighCommand= new CeilingFanHighCommand(ceilingFan);
//	CeilingFanMediumCommand cFanMediumCommand= new CeilingFanMediumCommand(ceilingFan);
//	CeilingFanOffCommand cFanOffCommand= new CeilingFanOffCommand(ceilingFan); 
//	remoteControl.setCommand(1, cFanHighCommand, cFanOffCommand);
//    remoteControl.setCommand(2, cFanMediumCommand, cFanOffCommand);
//    
//    remoteControl.onButtonWasPushed(1);
//    remoteControl.offButtonWasPushed(1);
//    remoteControl.undoButtonWasPushed();
//    System.out.println(remoteControl);
//    
//    
//    remoteControl.offButtonWasPushed(2);
//    remoteControl.onButtonWasPushed(2);
//    remoteControl.offButtonWasPushed(2);
//    remoteControl.undoButtonWasPushed();
//	System.out.println(remoteControl);
	
	Light light=new Light("toilet");
	LightOnCommand lightOn=new LightOnCommand(light);
	LightOffCommand lightOff=new LightOffCommand(light);
	
	CeilingFan ceilingFan=new CeilingFan("Libving Room");
	CeilingFanHighCommand cfHighCommand=new CeilingFanHighCommand(ceilingFan);
	CeilingFanOffCommand cfOffCommand=new CeilingFanOffCommand(ceilingFan);
	
	Command [] partyOnCommand={lightOn,cfHighCommand};
	Command [] partyOffCommand={lightOff,cfOffCommand};
	
	MacroCommand macroOnCommand= new MacroCommand(partyOnCommand);
	MacroCommand macroOfCommand =new MacroCommand(partyOffCommand);
	remoteControl.setCommand(6,macroOnCommand,macroOfCommand);
	
	System.out.println(remoteControl);
	
	System.out.println("--Macro on button---");
    remoteControl.onButtonWasPushed(6);
    
    System.out.println("---Macro Off button-----");
    remoteControl.offButtonWasPushed(6);
    
    System.out.println("--now comes undo button--");
    remoteControl.undoButtonWasPushed();
    
    System.out.println(remoteControl);
	
	
	
	}
}
