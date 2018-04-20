package AbstractFactoryDESIGNPattern;

public abstract class Pizza {
	
	String name ;
	Sauce sauce;
	Dough dough;
	Veggies [] veggies;
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clams;
	
	abstract void prepare();
	
	void bake(){
		System.out.println("bake for 25 minutes at 350");
	}
	
	void cut(){
		System.out.println("cutting the pizza into diagnol slices");
		
	}
	
	void box(){
		
		System.out.println("place pizza in official PizzaStore box");
	}
	
	void setName(String name){
		this.name=name;
	}
	
	public String returnName(){
		return name;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append("---- " + name + " ----\n");
		if (dough != null) {
			result.append(dough);
			result.append("\n");
		}
		if (sauce != null) {
			result.append(sauce);
			result.append("\n");
		}
		if (cheese != null) {
			result.append(cheese);
			result.append("\n");
		}
		if (veggies != null) {
			for (int i = 0; i < veggies.length; i++) {
				result.append(veggies[i]);
				if (i < veggies.length-1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		if (clams != null) {
			result.append(clams);
			result.append("\n");
		}
		if (pepperoni != null) {
			result.append(pepperoni);
			result.append("\n");
		}
		return result.toString();
	}
		
	}


