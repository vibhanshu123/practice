package AbstractFactoryDESIGNPattern;

public class CheesePizza extends Pizza{
	
	PizzaIngredientFactory pizzaIngredientFactory;

	@Override
	void prepare() {
		System.out.println("preparing"+name);
		dough=pizzaIngredientFactory.createDough();
		cheese=pizzaIngredientFactory.createCheese();
		sauce=pizzaIngredientFactory.createSauce();
		veggies=pizzaIngredientFactory.createVeggies();
		
	}

	public CheesePizza(PizzaIngredientFactory ingredientFactory){
		this.pizzaIngredientFactory = ingredientFactory;
	}
	


}
