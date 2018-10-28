package java8;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8FunctionalInterfaces {
	
	public static void main(String[] args) {
		
		//Predicates are boolean-valued functions of one argument. The interface contains various
		//default methods for composing predicates to complex logical terms (and, or, negate)
		
		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		System.out.println(isEmpty.test("asdf"));
		
		
		//Functions
		//Functions accept one argument and produce a result. Default methods can be used 
		//to chain multiple functions together (compose, andThen).

		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123"));     // "123"
		
		//Suppliers
		//Suppliers produce a result of a given generic type.
		//Unlike Functions, Suppliers don't accept arguments.
		Supplier<Person1> personSupplier = Person1::new;
		personSupplier.get();   // new Person
		
		//Consumers
		//Consumers represents operations to be performed on a single input argument.

		Consumer<Person1> greeter = (p) -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person1("Luke", "Skywalker"));
		
		//Comparators
		//Comparators are well known from older versions of Java. 
		//Java 8 adds various default methods to the interface.

		Comparator<Person1> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person1 p1 = new Person1("John", "Doe");
		Person1 p2 = new Person1("Alice", "Wonderland");

		System.out.println(comparator.compare(p1, p2));             // > 0
		System.out.println(comparator.reversed().compare(p1, p2));  // < 0
		
		//Optionals
		//Optionals are not functional interfaces, instead it's a nifty utility to prevent 
		//NullPointerException.It's an important concept for the next section,
		//so let's have a quick look at how Optionals work.
		
		//Optional is a simple container for a value which may be null or non-null. 
		//Think of a method which may return a non-null result but sometimes return nothing.
	    //Instead of returning null you return an Optional in Java 8.
		
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));  
		
	}

}
