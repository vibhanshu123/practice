package io.javabrains.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1Excercisejava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), 
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), 
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// sort list by last name
		Collections.sort(people,(o1,o2)->o1.getLname().compareTo(o2.getLname()));
       System.out.println("print all persons");
		// create a method that prints all elements in the list
       printConditinally(people,p->true);

		// create a method that prints all people that have last name beginning with c
		// the above method is very inflexible , means if we want to print starting with D wwe
		// will have to write a completely new method
		// lets write a better code such that printConditionally
		System.out.println("Printing all people lname begginning with c");
		printConditinally(people, p->p.getLname().startsWith("C"));
		

		System.out.println("Printing all people fname begginning with c");
		printConditinally(people, p-> p.getFname().startsWith("C"));
		
	}

	
	private static void printConditinally(List<Person> people, Condition c) {
		for (Person p : people) {
			if (c.test(p)) {
				System.out.println(p.toString());
			}
		}

	}

}

