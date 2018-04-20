/**
 * 
 */
package algorithms.moderate;

/**
 * @author Vibs
 *
 */
public class LinkedListNode {
	
	private LinkedListNode next ;
	
	private Integer data ;
	
	
	public LinkedListNode(Integer data) {
		this.data = data ;
	}

	public LinkedListNode(Integer data, LinkedListNode next) {
		this.data = data ;
		this.next = next ;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

}
