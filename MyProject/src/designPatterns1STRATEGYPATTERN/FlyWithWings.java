package designPatterns1STRATEGYPATTERN;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("i am a duck who knows how to fly , so i m flying");
		
	}

}
