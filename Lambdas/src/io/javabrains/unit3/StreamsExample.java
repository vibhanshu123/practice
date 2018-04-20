package io.javabrains.unit3;

import java.util.Arrays;
import java.util.List;

import io.javabrains.unit1.Person;

public class StreamsExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));
		
		people.stream()
		.filter(p->p.getLname().startsWith("C"))
		.forEach(p->System.out.println(p.getFname()));
		
		System.out.println(people.parallelStream().filter(p->p.getLname().startsWith("D")).count());
	}

}
