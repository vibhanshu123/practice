/**
 * 
 */
package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vibs
 * @param <K>
 *
 */
public class LRUCacheUsingDoublyLinkedList<K,T> implements CacheStrategy<K, T>{

	DLLNode head,tail ;
	
	Map<K,DLLNode> map;
	
	int  maxSize ;
	
	
	public LRUCacheUsingDoublyLinkedList(int maxSize) {
		this.maxSize = maxSize ;
		map = new HashMap<K, DLLNode>();
		head = new DLLNode(null, null) ;
		tail = new DLLNode(null,null) ;
		head.setNext(tail) ;
		tail.setPrev(head) ;
	}
	
	private void attach(DLLNode head , DLLNode node){
	  	node.setNext(head.getNext());
	  	node.setPrev(head);
	  	head.getNext().setPrev(node);
	  	head.setNext(node);
	}
	
	private void detach (DLLNode node){
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
	}
	
	@Override
	public T get(K key) {
		DLLNode<K,T> node = map.get(key);
		if(node == null) return null ;
		if(map.size()==1) return node.getData() ;
		detach(node);
		attach(head, node);
		return node.getData() ;
	}


	@Override
	public void put(K key, T data) {
		if (maxSize <=0) return ;
		
		DLLNode node = map.get(key);
		if(node != null){
			detach(node);
			node.setData(data);
			attach(head, node);
		}else{
			if(map.size()>=maxSize){
				map.remove(tail.prev.getKey());
				detach(tail.prev);
			}
			DLLNode<K,T> newNode = new DLLNode(key, data);
			map.put(key, newNode);
			attach(head, newNode);
		}
		
		
	}
	
	public static void main(String [] args){
		CacheStrategy<String, Integer> cs = new LRUCacheUsingDoublyLinkedList<String, Integer>(5);
		cs.put("A", 1);
		cs.put("B", 2);
		cs.put("C",3);
		cs.put("B", 4);
		cs.put("D", 5);
		cs.put("E", 6);
		cs.get("C");
		cs.put("F", 7);
		cs.put("G", 8);
		System.out.println(cs.get("A"));
	
		
		
	}

	public Map<K, DLLNode> getMap() {
		return map;
	}

	public void setMap(Map<K, DLLNode> map) {
		this.map = map;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

}
