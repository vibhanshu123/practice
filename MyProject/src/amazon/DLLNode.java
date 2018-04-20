/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class DLLNode<K,T> {
	
	DLLNode prev ;
	
	DLLNode next ;
	
	K key ;
	
	T data ;
	
 
public DLLNode(K key, T data) {
	this.key = key;
	this.data = data ;
}


public DLLNode getPrev() {
	return prev;
}


public void setPrev(DLLNode prev) {
	this.prev = prev;
}


public DLLNode getNext() {
	return next;
}


public void setNext(DLLNode next) {
	this.next = next;
}


public K getKey() {
	return key;
}


public void setKey(K key) {
	key = key;
}


public T getData() {
	return data;
}


public void setData(T data) {
	this.data = data;
}





}
