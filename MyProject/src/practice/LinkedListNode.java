/**
 * 
 */
package practice;

/**
 * @author Vibs
 *
 */
public class LinkedListNode<E> {
	
	private LinkedListNode<E> next ;
	
	private E data ;
	
	public LinkedListNode<E> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<E> next) {
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * 
	 */
	public LinkedListNode(E data, LinkedListNode<E> next) {
		this.data = data  ;
		this.next = next ;
	}
	
	@Override
	public boolean equals(Object o){
		if((o!=null)&&!(o instanceof LinkedListNode))
			return false;
		LinkedListNode<E> node =(LinkedListNode<E>) o;
		if ((node == null)&&(this ==null)) return true;
		if(this.getData()!=null&&node.getData()!=null){
			if(node.getData()==this.getData())
				return true;
			}
		return false;	
	}
	
	@Override
	public String toString(){
		StringBuilder str= new StringBuilder();
		str.append(this.getData());
		return str.toString();	
	}

}
