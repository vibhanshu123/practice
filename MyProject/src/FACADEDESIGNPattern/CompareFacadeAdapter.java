package FACADEDESIGNPattern;

public class CompareFacadeAdapter {
	
	public static void main(String [] args){
		System.out.println("Concept of Design pattern learned :");
		System.out.println("Priciple of least knowledge: talk only to your immediate friends");
		System.out.println("this is for maintaing low lwvwl of coupling in our designs");
		
		System.out.println("definition for FACADE:");
		System.out.println("Provides a unified interface to a set of interfaces in a subsystem, Fcade defines a higher level interface that makes the subsystem easier to use");
		System.out.println("1. When we need to simplify and unify a large interface or complex set of interfaces , we use a FACADE");
		System.out.println("2.A facade decouples a client from a complex subsystem");
		System.out.println("3.Implementing a facade requires that we compose the facade with its subsystem and use delegation to perform the work of the facade");
		System.out.println("4.We can implement more than one facade for a subsystem");
		
		System.out.println("------------------");
		
		System.out.println("definition for ADAPTER");
		System.out.println("Converts an interface of a class into another interface clients expect.");
		System.out.println("Lets classes work together that couldn't otherwise because of incompatible interfaces");
		System.out.println("1. When we need to use an existing class and its interface is not the one we need, we use an ADAPTER");
		System.out.println("2.An adapter changes an interface into one a client expects");
		System.out.println("3.Implementing an ADAPTER may require little work or a great deal of work depending on the size and complexity of the target interface");
		System.out.println("4.Two types Adapter pattern: OBJECT AND CLASS ADAPTERS, class adapters require multiple inheritance");
		
		System.out.println("-------------------");
		System.out.println("AN ADAPTER WRAPS AN OBJECT TO CHANGE ITS INTERFACE");
		System.out.println("A DECORATOR WRAPS AN OBJECT TO ADD NEW BEHAVIORS AND RESPONSIBILITIES ");
		System.out.println("A FACADE WRAPS A SET OF OBJECTS TO SIMPLIFY");
		
		
	}

}
