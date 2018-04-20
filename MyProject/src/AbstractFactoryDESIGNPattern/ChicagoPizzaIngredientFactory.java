package AbstractFactoryDESIGNPattern;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return new ShreddedMozzarellaCheese();
	}

	@Override
	public Clams createClam() {
		// TODO Auto-generated method stub
		return new FrozenClams();
	}

	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new ExtraThickCrustDough();
	}

	@Override
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return new SlicedPepperoni();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new PlumTomatoSauce();
	}

	@Override
	public Veggies[] createVeggies() {
		// TODO Auto-generated method stub
		Veggies [] veggies={new BlackOlives(),new Spinach(),new Eggplant()};
		return null;
	}

}
