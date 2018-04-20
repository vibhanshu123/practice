package FACTORYDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	
	String name;
	String dough ;
	String sauce;
	List toppings=new ArrayList();
	
	public void prepare(){
		System.out.println("preparing.."+name);
		System.out.println("tossing dough....");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings ...");
		for(int i=0;i<toppings.size();i++){
			System.out.println(""+toppings.get(i));
		}
	}
	
	public void bake(){
		System.out.println("baking for 25 minutes at 350");
	}
	
	public void cut(){
		System.out.println("cutting the pizza into diagnol slices");
		
	}
	
	public void box(){
	    System.out.println("PLace pizzza in official pizza store box");	
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		StringBuffer display=new StringBuffer();
		display.append("----------"+name+"-------------\n");
		display.append(dough+"\n");
		display.append(sauce+"\n");
		for(int i=0;i<toppings.size();i++){
			display.append((String)toppings.get(i)+"\n");
		}
		
		return display.toString();
	}
	

}
