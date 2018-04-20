package FACTORYDesignPatterns;

public class PizzaTestDrive {
	
	public static void main(String[] args){
		PizzaStore ps=new ChicagoPizzaStore();
		PizzaStore ns=new NyPizzaStore();
		
		ps.orderPizza("Cheese");
		ns.orderPizza("pepperoni");
		ps.orderPizza("pepperoni");
		
	}

}
