package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private class Node{
        private Node next;
        private int key ;
        private int value;
        private Node pre;
        
       public Node(int key, int value){
           this.key =key;
           this.value=value;
           
       }
       
    }
     Map<Integer,Node>  data= new HashMap<Integer,Node>();
      private int capacity;
      private Node head;
      private Node tail;
      
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
    }
    
    public void removeNode(Node node){
        if(node.pre!=null){
            node.pre.next=node.next;
        }else{
            head=node.next;
        }
        
        if(node.next!=null){
            node.next.pre=node.pre;
        }else{
            tail=node.pre;
        }
    }
    
    public void moveToFront(Node node){
        node.pre=null;
        node.next=head;
        
        if(head!=null)
          head.pre=node;
        
        head=node;
        
        if(tail==null)
            tail=head;
 
 }
    
    public int get(int key) {
    	   Node node = data.get(key);
    	   if(node!=null) {
    		 removeNode(node);  
    		 moveToFront(node);
    		 return node.value;
    	   }
    	   return -1;
         
    }
    
    public void put(int key, int value) {
    	  Node node = data.get(key);
    	  if(node!=null) {
    		  node.value=value;
    		  removeNode(node);
    		  moveToFront(node);
    	  }else {
    		  node = new Node(key, value);
    		  if(data.size()>=capacity) {
    			  data.remove(tail.key);
    			  removeNode(tail);
    		  }
    		  moveToFront(node);
    		  data.put(key, node);
    	  }
        
        
    }
}
