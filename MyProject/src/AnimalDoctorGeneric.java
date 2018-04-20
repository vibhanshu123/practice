import java.util.ArrayList;
import java.util.List;


public class AnimalDoctorGeneric {
	
	public void checkPolymorphism(List<? extends Polymorphism> polymorphisms){
		//polymorphisms.add(new Bird1());
		
		for(Polymorphism p:polymorphisms)
			p.checkUp();
	}
	
	public static void main(String[] args){
		
		List<Polymorphism> poly=new ArrayList<Polymorphism>();
		poly.add(new Dog1());
		poly.add(new Dog1());
		
		
		List<Dog1> dogs=new ArrayList<Dog1>();
		dogs.add(new Dog1());
		dogs.add(new Dog1());
		
		//List<Cat1> cats=new ArrayList<Cat1>();
		poly.add(new Cat1());
		poly.add(new Cat1());
		
		
		//List<Bird1> birds=new ArrayList<Bird1>();
	     poly.add(new Bird1());
		 poly.add(new Bird1());
		
		AnimalDoctorGeneric an=new AnimalDoctorGeneric();
		an.checkPolymorphism(poly);
		//an.checkPolymorphism(cats);
		//an.checkPolymorphism(birds);
	}

}
