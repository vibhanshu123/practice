package linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListProblems {
	
	public static LinkedList<Integer> createLinkedList() {
		LinkedList<Integer> list= new LinkedList<Integer>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		return list;
		
		
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list= createLinkedList();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4,10, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = 
		    numbers.stream()
		           .filter(n -> {
		                    System.out.println("filtering " + n); 
		                    return n % 2 == 0;
		                  })
		           .map(n -> {
		                    System.out.println("mapping " + n);
		                    return n * n;
		                  })
		           .limit(2)
		           .collect(Collectors.toList());
		boolean expensive =
			    numbers.stream()
			                .allMatch(n -> n > 100);
	    System.out.println(numbers);
	    System.out.println(expensive);
	    System.out.println(numbers.stream().reduce(0,(a, b) -> a + b));
	//	recursiveReverseLinkedList(list.getHead());
	//	list.print(nonrecursiveReverseLinkedlist(list.getHead()));
	}
	
	
	private static LinkedListNode<Integer> nonrecursiveReverseLinkedlist(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		LinkedListNode<Integer> next = null;
		while(curr!=null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;
		}
		return prev;
	}

	public static void recursiveReverseLinkedList(LinkedListNode<Integer> head) {
	   if(head==null)
		   return;
	   recursiveReverseLinkedList(head.getNext());
	   System.out.println(head.getData());
	}
    
	
		

}
