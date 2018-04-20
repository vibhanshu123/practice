
abstract class Polymorphism {
	
	public abstract void checkUp();

}

class Dog1 extends Polymorphism{

	@Override
	public void checkUp() {
		System.out.println("Dog Checkup");
		
	}
	
}

class Bird1 extends Polymorphism{

	@Override
	public void checkUp() {
		// TODO Auto-generated method stub
		System.out.println("Bird checkup");
		
	}
	
}

class Cat1 extends Polymorphism{

	@Override
	public void checkUp() {
		// TODO Auto-generated method stub
		System.out.println("Cat checkup");
		
	}
	
}



