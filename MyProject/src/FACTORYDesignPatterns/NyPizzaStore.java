package FACTORYDesignPatterns;

public class NyPizzaStore extends PizzaStore{

	@Override
	Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("Cheese")){
			return new NyStyleCheesePizza();
		}else if(type.equals("veggie")){
			return new NyStyleVeggiePizza();
		}else if(type.equals("clam")){
			return new NyStyleClamPizza();
		}else if(type.equals("pepperoni")){
			return new NyStylePepperoniPizza();
		}else return null;
		
	}
	

}
