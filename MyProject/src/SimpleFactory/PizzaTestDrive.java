package SimpleFactory;

public class PizzaTestDrive {
	
	public static void main(String [] args){
		SimpleFactory factory=new SimpleFactory();
		PizzaStore pizzaStore =new PizzaStore(factory);
		pizzaStore.orderPizza("cheese");
		
	}

}
