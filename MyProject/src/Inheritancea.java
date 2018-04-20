
public class Inheritancea {
	
	 public void doStuff(){
		 System.out.println("do some stuff");
	 }

	
}

class x extends Inheritancea{
	public void fuckSomeone(){
		System.out.println("fucking was fun");
	}
}


class c extends x implements Interface{
	
public void noImplemetedMethod(){
	System.out.println("super classes have already implented so no need to implement");
}
}