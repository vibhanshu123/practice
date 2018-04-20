package AbstractFactoryDESIGNPattern;

public class PointsToNote {
	public static void main(String [] args){
		
		System.out.println("DESIGN CONCEPT LEARNED FROM THIS :");
		System.out.println("Depend on abstractions :not on concrete classes");
		
		System.out.println("both encapsulate object creation");
		System.out.println("to keep applications loosely coupled");
		System.out.println("and less dependant on applications");
		
		System.out.println("ABSTARCT FACTORY METHOD:");
		System.out.println("Use me whenever you have families");
		System.out.println("of products you need to create and");
		System.out.println("you want to make sure your client create");
		System.out.println("products that belong together");
		System.out.println("provide an interface for creating families");
		System.out.println("of related or dependant objects");
		System.out.println("without specifying their concrete classes");
		
		
		
		System.out.println("FACTORY METHOD");
		System.out.println("use me to decouple your client code");
		System.out.println("from the concrete classes");
		System.out.println("you need to instantiate or if");
		System.out.println("you dont know ahead of time all");
		System.out.println("the concrete classes you are going to need");
		System.out.println("to use me just subclass and implement my factory method");
		
		
		System.out.println("both pattersns encapsulate object creation");
	System.out.println("and lead to more decoupled flexible designs");
	System.out.println("------DIFFERENCES---------");
	System.out.println("factory method relies on inheritance");
	System.out.println("asbstract relies on object composition:");
	System.out.println("object creation is implemented in the methods");
	System.out.println("exposed in the factory interface");
	
	System.out.println("DEPENDENCY INVERSION PRINCIPLE GUIDES US TO AVOID");
	System.out.println("DEPENDENCIES ON CONCRETE TYPES");
	System.out.println("AND TO STRIVE FOR ABSTRACTIONS");
	
	
	
	}
	
	
	
	
	

}
