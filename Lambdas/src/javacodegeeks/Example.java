package javacodegeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.javabrains.unit1.Person;

public class Example {
	
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Virat", "Kohli",22));
		personList.add(new Person("Arun", "Kumar",25));
		personList.add(new Person("Rajesh", "Mohan", 32));
		personList.add(new Person("Rahul", "Dravid", 35));
		olderway(personList);
		newWay(personList);

	}
	
	public static void olderway(List<Person> personList) {
		List<Person> olderThan30OldWay = new ArrayList<>();
		for ( Person p : personList){
		  if ( p.getAge() >= 30){
		    olderThan30OldWay.add(p);
		  }
		}
		System.out.println(olderThan30OldWay);

	}
	
	public static void newWay(List<Person> personList) {
		List<Person> olderThan30 =
				    //Create a Stream from the personList
				    personList.stream().
				    //filter the element to select only those with age >= 30
				    filter(p -> p.getAge() >= 30).
				    //put those filtered elements into a new List.
				    collect(Collectors.toCollection(() -> new ArrayList<Person>()));
				System.out.println(olderThan30);

	}
	 

}
