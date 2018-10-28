package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestAllClasses {
	
	public static void main(String [] args) {
     Formula formula = new Formula() {
		
		@Override
		public double calculate(int a) {
			return sqrt(a*100);
		}
	};
	
	formula.calculate(100);
	formula.sqrt(100);
	

	
	//Let's start with a simple example of how to sort a list of strings in prior versions of Java:


	List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

	//normal compare
	Collections.sort(names, new Comparator<String>() {

		@Override
		public int compare(String a, String b) {
			return a.compareTo(b);
		}
	});
	
	//lambda
     Collections.sort(names, (a, b) -> a.compareTo(b));
	
	
	/*How does lambda expressions fit into Javas type system? Each lambda corresponds to a given type, 
	 * specified by an interface. A so called functional interface must contain exactly one abstract 
	 * method declaration. Each lambda expression of that type will be matched to this abstract method. 
	 * Since default methods are not abstract you're free to add default methods to your functional 
	 * interface.

     We can use arbitrary interfaces as lambda expressions as long as the interface only contains 
     one abstract method. To ensure that your interface meet the requirements, you should add the 
     @FunctionalInterface annotation. The compiler is aware of this annotation and throws a compiler
      error as soon as you try to add a second abstract method declaration to the interface.
     */
	
	Converter<String, Integer> converter = (from->Integer.valueOf(from));
	Integer converted=converter.convert("123");
	System.out.println(converted);
	
	//Method and constructor references 
	
	Converter<String, Integer> converterMethodReference = Integer::valueOf;
	converted = converterMethodReference.convert("123");
	System.out.println(converted);   // 123
	
	Something something = new Something();
	Converter<String, String> soemthingnew= something::startsWith;
	String convert =soemthingnew.convert("Java");
	System.out.println(convert);
	
	PersonFactory<Person1> p = Person1::new;
	Person1 person = p.create("Peter", "Parker");
	
	//We can read final local variables from the outer scope of lambda expressions:
	
	final int num = 1;
	Converter<Integer, String> stringConverter =
	        (from) -> String.valueOf(from + num);

	stringConverter.convert(2);     // 3
	
	//However num must be implicitly final for the code to compile. The following code does not compile:
//	int num = 1;
//	Converter<Integer, String> stringConverter =
//	        (from) -> String.valueOf(from + num);
//	num = 3;
	
  }
	
	
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
