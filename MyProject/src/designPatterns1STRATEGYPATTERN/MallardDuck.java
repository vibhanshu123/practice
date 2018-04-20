package designPatterns1STRATEGYPATTERN;

public class MallardDuck extends Duck{
	
	public MallardDuck(){
		quackBehavior= new Squeak();
		flyBehavior =new FlyWithRocket();
	}
	
	public void display(){
		System.out.println(" i am a real mallard duck");
	}

}
