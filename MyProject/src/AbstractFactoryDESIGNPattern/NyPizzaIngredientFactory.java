package AbstractFactoryDESIGNPattern;

public class NyPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new ReggianoCheese();
	}

	@Override
	public Clams createClam() {
		// TODO Auto-generated method stub
		return new FreshClams();
	}

	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new ThinCrustDough();
	}

	@Override
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return new SlicedPepperoni();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new MarinaraSauce();
	}

	@Override
	public Veggies[] createVeggies() {
		// TODO Auto-generated method stub
		Veggies[] veggies={new Garlic(),new Onion(),new Mushrooms(),new RedPepper()};
		return veggies;
	}

}
