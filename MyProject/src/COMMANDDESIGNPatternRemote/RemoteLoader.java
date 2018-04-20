package COMMANDDESIGNPatternRemote;

public class RemoteLoader {
	
	public static void main(String [] args){
		RemoteControl remoteControl = new RemoteControl();
		Light livingRoomLight=new Light("Living Room");
		Light kitchenLight=new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		
		LightsOnCommand livingRoomLightsOnCommand=new LightsOnCommand(livingRoomLight);
		LightsOnCommand kitchenLightsOnCommand=new LightsOnCommand(kitchenLight);
		LightsOffCommand livingRoomLightsOffCommand= new LightsOffCommand(livingRoomLight);
		LightsOffCommand kitchenLightsOffCommand= new LightsOffCommand(kitchenLight);
		
		CeilingFanOnnCommand ceilingFanOnnCommand = new CeilingFanOnnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
		
		GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
		
		StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
		StereoOnWithDVDCommand stereoOnWithDVDCommand = new StereoOnWithDVDCommand(stereo);
		StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
		
		remoteControl.setCommand(0, livingRoomLightsOnCommand, livingRoomLightsOffCommand);
		remoteControl.setCommand(1, kitchenLightsOnCommand, kitchenLightsOffCommand);
		remoteControl.setCommand(2, ceilingFanOnnCommand, ceilingFanOffCommand);
		remoteControl.setCommand(3, garageDoorUpCommand, garageDoorDownCommand);
		remoteControl.setCommand(4, stereoOnWithDVDCommand, stereoOffCommand);
		
		System.out.println(remoteControl);
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);

		
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		

		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		

		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		

		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);
		
		remoteControl.onButtonWasPushed(5);
		remoteControl.offButtonWasPushed(5);
		
		
		
		
	}
  }
