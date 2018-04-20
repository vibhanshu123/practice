package AbstractFactoryDESIGNPattern;

public class VeggiesPizza extends Pizza{

	PizzaIngredientFactory ingredientFactory;
	
	public  VeggiesPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("preparing"+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		veggies=ingredientFactory.createVeggies();
		cheese=ingredientFactory.createCheese();
		
		
	}

}
