package io.javabrains.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.javabrains.unit1.Person;

public class MethodReferenceExample2 {
	
	public static void main(String [] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		
       System.out.println("print all persons");
       performConditinally(people,p->true,p->System.out.println(p));
       
       //can also be used as method references
       performConditinally(people,p->true,System.out::println);//p->method(p)
		
		
	}
	

	private static void performConditinally(List<Person> people, Predicate<Person> p,Consumer<Person> c) {
		for (Person person : people) {
			if (p.test(person)) {
				c.accept(person);
			}
		}

	}
	
	

}
