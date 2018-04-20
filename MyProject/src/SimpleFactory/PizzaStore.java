package SimpleFactory;

public class PizzaStore {
	
	SimpleFactory factory;

	public PizzaStore(SimpleFactory factory) {
		this.factory = factory;
	}
	
	public void orderPizza(String type){
		
		Pizza pizza=factory.createPizza(type);
		pizza.bake();
		pizza.cut();
		pizza.box();
		
	}

}
