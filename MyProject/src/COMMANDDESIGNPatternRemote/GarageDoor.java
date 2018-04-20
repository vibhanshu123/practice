package COMMANDDESIGNPatternRemote;

public class GarageDoor {
	
	String location="";
	
	public GarageDoor(String location){
		this.location=location;
	}
	
	public void up(){
	System.out.println(location+" gara door is up");	
	}
	
	public void down(){
	System.out.println(location+" garage door is down");	
	}
	
	public void lightsOn(){
		System.out.println(location+" garage door lights are on");
	}
	
	public void lightOff(){
		System.out.println(location+" garade door lights are off");
	}
	
	
	public void stop(){
		System.out.println(location+" gara door is stopped");
	}

}
