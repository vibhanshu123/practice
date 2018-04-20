package AbstractFactoryDESIGNPattern;

public abstract class PizzaStore {
	
	abstract Pizza createPizza(String type);
	
	public Pizza orderPizza(String type){
		
		Pizza pizza=createPizza(type);
		//System.out.println("preparing"+pizza.returnName());
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
		
	}
	
	

}
