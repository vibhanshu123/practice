package designPatterns1STRATEGYPATTERN;

public abstract class Duck {
	
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
    public void swim(){
    	System.out.println("all ducks swim: common functionality");
    }
    
    public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public Duck(){
    	
    }
    public abstract void display();
    public void performFly(){
    	flyBehavior.fly();
    }
    
    public void performQuack(){
    	quackBehavior.quack();
    }
    

}
