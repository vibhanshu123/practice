/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class DoubleLinkedList {
	
	private DoublyLinkedListNode head ;
	
	private DoublyLinkedListNode tail;
	
	private int size ;
	
	
	public DoubleLinkedList() {
	  head= new DoublyLinkedListNode(0);
	  tail=new DoublyLinkedListNode(0);
	  head.setNext(tail);
	  tail.setPrevious(head);
	}

	
	private DoublyLinkedListNode getNextNode(DoublyLinkedListNode referenceNode)throws BoundaryVioLationException{
		if(referenceNode == tail){
	      throw new BoundaryVioLationException("what");
		}
	    	return referenceNode.getNext();  
	   }
	
	private void addBefore(DoublyLinkedListNode referenceNode, int data){
		 DoublyLinkedListNode previous = this.getPreviousNode(referenceNode);  
		 DoublyLinkedListNode next = referenceNode ;
		 DoublyLinkedListNode newNode = new DoublyLinkedListNode(previous, next , data);
		 previous.setNext(newNode);
		 previous.setNext(newNode);
		 size ++ ;
	   }
	
	private void addAfter(DoublyLinkedListNode referenceNode, int data){
		 DoublyLinkedListNode next = this.getNextNode(referenceNode);  
		 DoublyLinkedListNode previous = referenceNode ;
		 DoublyLinkedListNode newNode = new DoublyLinkedListNode(previous, next , data);
		 newNode.setPrevious(referenceNode);
		 next.setPrevious(newNode);
		 size ++ ; 
	   }
	
	public void inserFirst(int data){
	   this.addAfter(head, data);	
	  
	}
	
	public void insertLast(int data){
		this.addBefore(tail, data);
	}
	
	public int  remove(DoublyLinkedListNode node){
		DoublyLinkedListNode previous= this.getPreviousNode(node);
		DoublyLinkedListNode next = this.getNextNode(node);
		previous.setNext(next);
		next.setPrevious(previous);
		node.setPrevious(null);
		node.setNext(null);
		size --;
		return node.getData();
	}
	
	private DoublyLinkedListNode getPreviousNode(DoublyLinkedListNode referenceNode)throws BoundaryVioLationException{
		if(referenceNode == head){
	      throw new BoundaryVioLationException("what");
		}
	    	return referenceNode.getPrevious();  
	   }
	
	public int removeFirst(){		
	  DoublyLinkedListNode tempNode = this.getNextNode(head);
	  return this.remove(tempNode);
	}
	
    public int removeLast(){     
      DoublyLinkedListNode tempNode = this.getPreviousNode(tail);
      return this.remove(tempNode);
	}
	
	public static void main(String [] args){		
     DoubleLinkedList dll = new DoubleLinkedList();		
	}

}
