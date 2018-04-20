package AbstractFactoryDESIGNPattern;

public class ClamsPizza extends Pizza{
	
	PizzaIngredientFactory ingredientFactory;

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		System.out.println("preparing"+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		cheese=ingredientFactory.createCheese();
		clams=ingredientFactory.createClam();
		
		
	}

	public ClamsPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	

}
