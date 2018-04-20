package COMMANDDESIGNPattern;


// now this is our client in command pattern speak
// the client is responsible for creating the command object
// the command object consists of a set of actions on a receiver.
public class RemoteControlTest {

	public static void main(String [] args){
		
		
		//remote is the INVOKER, it will PASSED a COMMAND OBJECT
		//than can be used to make requests
		SimpleRemoteControl src=new SimpleRemoteControl();
		
		//Now we create a Light Object , this will be receiver of the
		//requests
		Light light = new Light();
		
		
		//Here we create a command and pass it to the user
		LightOnCommand loc=new LightOnCommand(light);
		
		
		//Here i am passing the command to the invoker
		src.setCommand(loc);
		
		//Simulating the button being pressed
		src.buttonWasPressed();
		
		
		GarageDoor garageDoor = new GarageDoor();
		GarageOnCommand goc=new GarageOnCommand(garageDoor);
		src.setCommand(goc);
		src.buttonWasPressed();
		
		
	}
	
}
