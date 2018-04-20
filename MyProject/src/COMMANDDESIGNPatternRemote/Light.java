package COMMANDDESIGNPatternRemote;

public class Light {
	
	String location= "";
	public Light(String location){
		this.location=location;
		}
	
	public void lightOn(){
		System.out.println(location+" light is on");
		
	}
	
	public void lightOff(){
		System.out.println(location+" light is off");
	}

}
