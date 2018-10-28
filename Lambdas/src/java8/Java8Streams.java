package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Java8Streams {
	
	/*
	 * Streams
A java.util.Stream represents a sequence of elements on which one or more operations 
can be performed. Stream operations are either intermediate or terminal.
 While terminal operations return a result of a certain type, intermediate operations return the 
 stream itself so you can chain multiple method calls in a row.
  Streams are created on a source, e.g. a java.util.Collection like lists or sets
   (maps are not supported). Stream operations can either be executed sequential or parallel.
	 */
	
	/*Filter
	 * Filter accepts a predicate to filter all elements of the stream. 
	 * This operation is intermediate which enables us to call another stream operation
	 *  (forEach) on the result. ForEach accepts a consumer to be executed for each element in the 
	 *  filtered stream.
	 *   ForEach is a terminal operation. It's void, so we cannot call another stream operation.
      */
	
	public static void main(String [] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		stringCollection
	    .stream()
	    .filter((s) -> s.startsWith("a"))
	    .forEach(System.out::println);
		
		//Sorted
		//Sorted is an intermediate operation which returns a sorted 
		//view of the stream. The elements are sorted in natural order unless you
		//pass a custom Comparator.

		stringCollection
		    .stream()
		    .sorted()
		    .filter((s) -> s.startsWith("a"))
		    .forEach(System.out::println);
		
		System.out.println(stringCollection);
		// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1

		// "aaa1", "aaa2"
		
		//Map
		//The intermediate operation map converts each element into another object via 
		//the given function. The following example converts each string into an upper-cased string. 
		//But you can also use map to transform each object into another type. 
		//The generic type of the resulting stream depends on the generic type of the function 
		//you pass to map.

		stringCollection
	    .stream()
	    .map(String::toUpperCase)
	    .sorted((a, b) -> b.compareTo(a))
	    .forEach(System.out::println);
		
		//Match
		//Various matching operations can be used to check whether a certain predicate 
		//matches the stream. All of those operations are terminal and return a boolean result.
		
		boolean anyStartsWithA =
			    stringCollection
			        .stream()
			        .anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA);      // true

		boolean allStartsWithA =
			    stringCollection
			        .stream()
			        .allMatch((s) -> s.startsWith("a"));

			System.out.println(allStartsWithA);      // false

			boolean noneStartsWithZ =
			    stringCollection
			        .stream()
			        .noneMatch((s) -> s.startsWith("z"));

			System.out.println(noneStartsWithZ);      // true
			
			
		//	Count
		//	Count is a terminal operation returning the number of elements in the stream as a long.
			
			long startsWithB =
				    stringCollection
				        .stream()
				        .filter((s) -> s.startsWith("b"))
				        .count();

				System.out.println(startsWithB); 
				
				
		//	Reduce
		//	This terminal operation performs a reduction on the elements of
		//	The stream with the given function. The result is an Optional holding the reduced value.	
				
		Optional<String> reduced = stringCollection
				.stream()
				.sorted()
				.reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
		
		//Map
		//As already mentioned maps don't support streams. 
		//Instead maps now support various new and useful methods for doing common tasks.
		
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}

		map.forEach((id, val) -> System.out.println(val));
		
		//This example shows how to compute code on the map by utilizing functions:

			map.computeIfPresent(3, (num, val) -> val + num);
			System.out.println(map.get(3));             // val33

			map.computeIfPresent(9, (num, val) -> null);
			System.out.println(map.containsKey(9));     // false

			map.computeIfAbsent(23, num -> "val" + num);
			System.out.println(map.containsKey(23));    // true
			System.out.println(map.get(23));

			map.computeIfAbsent(3, num -> "bam");
			System.out.println(map.get(3));             // val33
			
			//Next, we learn how to remove entries for a a given key, only if it's currently
			//mapped to a given value:

			map.remove(3, "val3");
			map.get(3);             // val33

			map.remove(3, "val33");
			map.get(3);             // null
			
			System.out.println(map.getOrDefault(42, "not found"));  // not found
			
			//Merging entries of a map is quite easy:

			map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
			System.out.println(map.get(9));             // val9

			map.merge(9, "xyz", (value, newValue) -> value.concat(newValue));
			System.out.println(map.get(9));             // val9concat
		
	}
}
