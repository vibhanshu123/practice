package AbstractFactoryDESIGNPattern;

public class PepperoniPizza extends Pizza {

	PizzaIngredientFactory ingredientFactory;
	
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("preparing"+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		pepperoni=ingredientFactory.createPepperoni();
		cheese=ingredientFactory.createCheese();
		veggies=ingredientFactory.createVeggies();
		
	}

}
