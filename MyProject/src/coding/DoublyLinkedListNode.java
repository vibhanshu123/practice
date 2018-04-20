/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class DoublyLinkedListNode {
	
	private DoublyLinkedListNode next;
	
	private DoublyLinkedListNode previous;
	
	private int data;
	
	/**
	 * 
	 */
	public DoublyLinkedListNode(int data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}
	
	
	public DoublyLinkedListNode(DoublyLinkedListNode prev, DoublyLinkedListNode next, int data) {
		this.next = next;
		this.previous = prev ;
		this.data = data ;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}

	public DoublyLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode previous) {
		this.previous = previous;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
