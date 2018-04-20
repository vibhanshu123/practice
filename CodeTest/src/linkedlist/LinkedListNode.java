package linkedlist;

public class LinkedListNode<E> {
	
	private LinkedListNode<E> next= null;
	private E data = null;
	
	public LinkedListNode<E> getNext() {
		return next;
	}

	public E getData() {
		return data;
	}

	public void setNext(LinkedListNode<E> next) {
		this.next = next;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	
	

}
