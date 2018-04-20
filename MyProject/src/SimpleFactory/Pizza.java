package SimpleFactory;

import java.util.ArrayList;

abstract public class Pizza {
	
	String name;
	String sauce;
	String dough;
	
	ArrayList toppings= new ArrayList();
	
	void cut(){
		System.out.println("cutting"+name);
	}
	
	void bake(){
		System.out.println("baking "+name);
	}
	
	void box(){
		System.out.println("boxing"+name);
	}
	
	void prepare(){
		System.out.println("preparing"+name);
	}

	public String toString(){
		
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(dough + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < toppings.size(); i++) {
			display.append((String )toppings.get(i) + "\n");
		}
		return display.toString();
		
	}
	
}
