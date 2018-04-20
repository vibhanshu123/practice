package FACTORYDesignPatterns;

public abstract class PizzaStore {
	
	 abstract Pizza createPizza(String type);
	 
	 public void orderPizza(String type){
		Pizza pizza=createPizza(type); 
		System.out.println("Making a pizza"+pizza.getName()+"-----");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
      }

}
