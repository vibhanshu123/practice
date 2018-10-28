package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsInJava8Examples {
	
	public static void main(String[] args) {
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		//Collect
		//Collect is an extremely useful terminal operation to transform the elements of the stream 
		//into a different kind of result, e.g. a List, Set or Map. Collect accepts a Collector which
		//consists of four different operations: a supplier, an accumulator, a combiner and a finisher
		
		List<Person> filtered =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList());

			System.out.println(filtered); 
			
			
			Map<Integer, List<Person>> personsByAge = persons
				    .stream()
				    .collect(Collectors.groupingBy(p -> p.age));

				personsByAge
				    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));	
				
				Double averageAge = persons
					    .stream()
					    .collect(Collectors.averagingInt(p -> p.age));
				
				IntSummaryStatistics ageSummary =
					    persons
					        .stream()
					        .collect(Collectors.summarizingInt(p -> p.age));

					System.out.println(ageSummary);
					
					String phrase = persons
						    .stream()
						    .filter(p -> p.age >= 18)
						    .map(p -> p.name)
						    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

						System.out.println(phrase);	
						
						
						Map<Integer, String> map = persons
							    .stream()
							    .collect(Collectors.toMap(
							        p -> p.age,
							        p -> p.name,
							        (name1, name2) -> name1 + ";" + name2));

							System.out.println(map);		
							
							
			//Now that we know some of the most powerful built-in collectors, 
		    //let's try to build our own special collector. We want to transform all persons of the 
			//stream into a single string consisting of all names in upper letters separated by the | 
		    //pipe character. In order to achieve this we create a new collector via Collector.of(). 
			//We have to pass the four 
		    //ingredients of a collector: a supplier, an accumulator, a combiner and a finisher.	
							
		Collector<Person, StringJoiner, String> personNameCollector = 
				Collector.of(
				() -> new StringJoiner(" | "), // supplier
				(j, p) -> j.add(p.name.toUpperCase()), // accumulator
				(j1, j2) -> j1.merge(j2), // combiner
				StringJoiner::toString); // finisher

		String names = persons
				.stream()
				.collect(personNameCollector);

		System.out.println(names); // MAX | PETER | PAMELA | DAVID	
		
		
		//FlatMap transforms each element of the stream into a stream of other objects. 
		//So each object will be transformed into zero, one or multiple other objects backed by streams.
		//The contents of those streams will then be placed into the returned stream of the flatMap
		//operation.
						
		
		List<Foo> foos = new ArrayList<>();

		// create foos
		IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));

		// create bars
		foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
		
		//Now we have a list of three foos each consisting of three bars.
      //FlatMap accepts a function which has to return a stream of objects. 
	  //So in order to resolve the bar objects of each foo, we just pass the appropriate function:
		
		foos.stream()
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
		
		
		IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))
	    .peek(f -> IntStream.range(1, 4)
	    .mapToObj(i -> new Bar("Bar" + i + "<-"+ f.name))
	    .forEach(f.bars::add))
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
		
		
		//Reduce
		//The reduction operation combines all elements of the stream into a single result. 
		//Java 8 supports three different kind of reduce methods. 
		//The first one reduces a stream of elements to exactly one element of the stream. 
		//Let's see how we can use this method to determine the oldest person:

		persons.stream()
		.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
		.ifPresent(System.out::println); // Pamela
		
		
		//The second reduce method accepts both an identity value and a BinaryOperator accumulator. 
		//This method can be utilized to construct a new Person with the aggregated names and 
		//ages from all other persons in the stream:
		
		Person result = persons
			        .stream()
			        .reduce(new Person("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

			System.out.format("name=%s; age=%s", result.name, result.age);
			// name=MaxPeterPamelaDavid; age=76
			
		//The third reduce method accepts three parameters: an identity value, a BiFunction 
		//accumulator and a combiner function of type BinaryOperator. Since the identity values 
		//type is not restricted to the Person type, 
	    //we can utilize this reduction to determine the sum of ages from all persons:	
		
			Integer ageSum = persons
				    .stream()
				    .reduce(0, (sum, x) -> sum += x.age, (sum1, sum2) -> sum1 + sum2);

				System.out.println(ageSum); 
				
				
				Integer ageSum1 = persons
					    .stream()
					    .reduce(0,
					        (sum, p) -> {
					            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
					            return sum += p.age;
					        },
					        (sum1, sum2) -> {
					            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
					            return sum1 + sum2;
					        });
				
				System.out.println(ageSum1);
				
				
				ForkJoinPool commonPool = ForkJoinPool.commonPool();
				System.out.println(commonPool.getParallelism()); 
			
		
	}

}
