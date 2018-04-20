/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class LinkedListNode {
	
	private int data;
	
	private LinkedListNode next = null;
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	/**
	 * 
	 */
	public LinkedListNode(int data) {
		this.data = data;
	}
	
	/**
	 * 
	 */
	public LinkedListNode(int data , LinkedListNode next) {
	   this.data = data ;
	   this.next = next;
	}

}
