package designPatterns1STRATEGYPATTERN;

public class MiniDuckSimulator {
	
	public static void main(String[] args){
		
		System.out.println("This is simulation of strategy pattern");
		
		System.out.println("definition: the strategy pattern defines ");
		System.out.println("algorithms, encapsulates each one");
		System.out.println("and makes them interchangeable");
		System.out.println("strategy lets the algorithm vary independantly");
		System.out.println("from clients tha uses it");
		
		Duck mallard=new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		mallard.display();
		
		Duck model=new ModelDuck();
		model.performFly();
		model.performQuack();
		model.setQuackBehavior(new Squeak());
		model.setFlyBehavior(new FlyWithRocket());
		model.performFly();
		model.performQuack();
		
	}

}
