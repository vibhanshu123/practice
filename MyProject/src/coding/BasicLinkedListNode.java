/**
 * 
 */
package coding;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/**
 * @author Vibs
 *
 */
public class BasicLinkedListNode {
	
	BasicLinkedListNode next = null;
	int data;
	
	public BasicLinkedListNode(int d){
		data=d;
	}
	
	public BasicLinkedListNode appendToTail(int d){
		BasicLinkedListNode end = new BasicLinkedListNode(d);
		BasicLinkedListNode node = this;
		
		while (node.next!=null){
			node=node.next;
		}
		 
		node.next=end;
		return end;
	}

	/**
	 * 
	 */
	public BasicLinkedListNode deleteNode(BasicLinkedListNode linkedList, int d){
		BasicLinkedListNode node = linkedList;
		if(node.data==d){
		  return node.next;	
		}
		while(node.next != null){
			if(node.next.data == d){
				node.next=node.next.next;
				return linkedList;
			}
			node= node.next;
		}
		return linkedList;
	}	
		
	
	public static BasicLinkedListNode removeDuplicatesFromLinkedList(BasicLinkedListNode head){
		
		Map map = new HashMap() ;
		BasicLinkedListNode previous = null;
        BasicLinkedListNode headToReturn = head; 
        	
		while(head.next != null){
			if(map.containsKey(head.data)){
				previous.next=head.next;
			}else{
				map.put(head.data, true);
				previous = head;
			}
			head= head.next;
		}
		return headToReturn;
	}
	
	public static BasicLinkedListNode removeDuplicateWithoutUsingAnyDataStructure(BasicLinkedListNode node){
	  BasicLinkedListNode headToReturn = node;
	  if(node == null){
		  return node;
	  }
	 // BasicLinkedListNode prev = null;
	  BasicLinkedListNode current = node;
	  while(current != null){
		  BasicLinkedListNode next = current;
	    while(next.next!= null){
		  if(current.data==next.next.data){
			  next.next=next.next.next;
		      } else{
		  next= next.next;
		  }		
	     }
	    current=current.next;
	  }	  
	  return headToReturn;
	}
	
	
	public static BasicLinkedListNode KthToLast(int k, BasicLinkedListNode node){
		if(node == null){
			return null;
		}
		int count = 1;
		while(node.next!= null){
			node= node.next;
			count ++;
			if(count==k){
			  return node;	
			}
		}
	
		return null;
	}

	public static BasicLinkedListNode partitionLinkedList(BasicLinkedListNode head , int pivot){
		if (head == null){
			return null;
		}
		BasicLinkedListNode lowerHalf = null;
		BasicLinkedListNode upperHalf = null;
		while(head!=null){
			if(head.data>pivot){
				if(upperHalf == null) upperHalf= new BasicLinkedListNode(head.data);
				else upperHalf.appendToTail(head.data);					
			}else{
				if(lowerHalf == null) lowerHalf= new BasicLinkedListNode(head.data);
				else lowerHalf.appendToTail(head.data);		
			}
			head=head.next;
		}
		BasicLinkedListNode lowerHalfReturn = lowerHalf;
		while(lowerHalf.next!=null){
			lowerHalf= lowerHalf.next;
		}
		lowerHalf.next= upperHalf;
		
		return lowerHalfReturn;
	}
	
	public static boolean deleteNode(BasicLinkedListNode node){
		 if(node==null || node.next ==null){
			 return false;
		 }
	    BasicLinkedListNode current = node;
	    current.data = current.next.data;
	    current.next = current.next.next;
	    return true;	 
	}
	
	public static void main(String [] args){
		BasicLinkedListNode node = new BasicLinkedListNode(10);
		node.appendToTail(5);
		node.appendToTail(10);
		node.appendToTail(2);
		node.appendToTail(2);
		BasicLinkedListNode abc=node.appendToTail(3);
		iterateLinkedList(node);
		iterateLinkedList(removeDuplicatesFromLinkedList(node));
		iterateLinkedList(removeDuplicateWithoutUsingAnyDataStructure(node));
		iterateLinkedList(KthToLast(2, node));
		node.appendToTail(9);
		node.appendToTail(56);
		node.appendToTail(node);
		iterateLinkedList(node);
		System.out.println("sfsfsdf"+deleteNode(abc));
		iterateLinkedList(node);
		//iterateLinkedList(partitionLinkedList(node, 7));
	}

	/**
	 * @param node
	 */
	private void appendToTail(BasicLinkedListNode node) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param node
	 */
	private static void iterateLinkedList(BasicLinkedListNode node) {
		System.out.println("---------------------s");
		BasicLinkedListNode iterateNode = node;
		while (iterateNode.next != null){
			System.out.println(iterateNode.data);
			iterateNode= iterateNode.next;
		}
		System.out.println(iterateNode.data);
	}
	
	public static void findLoopInALinkedList(BasicLinkedListNode head){
		BasicLinkedListNode tortoise = head ;
		BasicLinkedListNode hare = head.next;
		
		while(hare.next != null || tortoise!=hare){
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		
		if(hare.next == null)
			System.out.println("the list does not have any loop");
		
		if(tortoise == hare){
			System.out.println(hare.data);
		}

		
	}
	
	
	
}
