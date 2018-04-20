package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;

import io.javabrains.unit1.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		System.out.println("using for loop");
		for(int i=0;i<people.size();i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("using for each");
		for(Person p:people) {
			System.out.println(p);
		}
		
		System.out.println("using lambda for each");
		//people.forEach(p->System.out.println(p));
		people.forEach(System.out::println);
	}

}
