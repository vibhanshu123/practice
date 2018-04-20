package AbstractFactoryDESIGNPattern;

public class NyPizzaStore extends PizzaStore {
	
	@Override
	Pizza createPizza(String type) {
		
		Pizza pizza =null;
		PizzaIngredientFactory ingredientFactory=new NyPizzaIngredientFactory();
		
		if(type.equals("cheese")){
		pizza=new CheesePizza(ingredientFactory);
		pizza.setName("New York Style Cheese pizza");
		}else if(type.equals("pepperoni")){
		pizza=new PepperoniPizza(ingredientFactory);
		pizza.setName("New York Style Pepperoni Pizza");
		}else if (type.equals("clam")){
		pizza=new ClamsPizza(ingredientFactory);
		pizza.setName("New York Style Clam Pizza");
		}else if(type.equals("veggie")){
		pizza=new VeggiesPizza(ingredientFactory);
		pizza.setName("New York Style Veggie Pizza");
		}return pizza;
		
		
	}

}
