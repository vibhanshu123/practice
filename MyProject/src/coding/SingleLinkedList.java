/**
 * 
 */
package coding;



/**
 * @author Vibs
 *
 */
public class SingleLinkedList {
	
	/**
	 * 
	 */
	private LinkedListNode head ;
	
	private LinkedListNode tail ;
	
	private LinkedListNode temp ;
	
	private int size ;
	
	public LinkedListNode getHead() {
		return head;
	}

	public LinkedListNode getTail() {
		return tail;
	}

	public int getSize() {
		return size;
	}

	public SingleLinkedList() {
	}
	
    public void add(int data){
    	if(head == null){
    		temp = new LinkedListNode(data);
    		head = tail = temp;
    	}else {
    		tail.setNext(new LinkedListNode(data));
    		tail=tail.getNext();
    	}
    	size ++;
    }
    

    
    public void addAtIndex(int data , int index){
    	if(index>size){
    		throw new OutOfIndexException("index greater than the size of the list");
    	}
    	if(index==size){
    		add(data);
    		return;
    	}else if(index ==0){
    	    temp = new LinkedListNode(data,head);
    	    head = temp ;    	    
    	}
    	else {
    		temp = head;
    	   for(int i =0 ;i<index;i++){
    		    temp=temp.getNext();
    	   }
    	   LinkedListNode node = new LinkedListNode(data,temp.getNext());
    	   temp.setNext(node);
    	}
    }
    	
    	public int getIndex(int data){
    		if(head == null)
    			return -1;
    		temp = head;
    		int count =0;
    		while(temp!=null){
    			if(temp.getData()!=data){
    				temp = temp.getNext();
    			}else {
    				return count ;
    			}
    			count ++;	   			
    		}
    		return -1;
    	}   
    	
    	public static void main(String [] args){
    		SingleLinkedList sl = new SingleLinkedList();
    		sl.add(1);
    		sl.add(34);
    		sl.add(56);
    		sl.add(44);
    		sl.add(23);
    		sl.addAtIndex(10,5 );
    		iterateLinkedList(sl);
    		System.out.println(getStartOfLoopFromCircularLinkedList(sl));
    		sl = makeACircularLinkedList(sl);
    		//iterateLinkedList(sl);
    		System.out.println(sl.getIndex(10));
    		System.out.println(getStartOfLoopFromCircularLinkedList(sl).getData());
    		iterateLinkedList(removeLoopFromCircularLinkedList(sl));
    		SingleLinkedList pali = new SingleLinkedList();
    		pali.add(1);
    		pali.add(2);
    		pali.add(4);
    		pali.add(6);
    		//pali.add(3);
    		pali.add(2);
    		pali.add(1);
    		pali.add(5);
    		
    		System.out.println(checkPalindromeForSingleLinkedList(pali));
    		//iterateLinkedList(swapAdjacentNodesInLinkedList(pali));
    		iterateLinkedList(pali);
    		System.out.println("----reverse of linked list----");
    	    SingleLinkedList list = reverseOfLinkedList(pali);
    		iterateLinkedList(list);
    		System.out.println("----k=5----");
    		iterateLinkedList(reverseOfLinkedListKth(list, 5));   		
    		System.out.println("asiudiasufauisfuias------------");
    		iterateLinkedList(list);
    		System.out.println("print in reverse-----");
    		printList(list.getHead());
    		
    		
    	}
    	
    	/**
		 * @param sl
		 */
		private static SingleLinkedList makeACircularLinkedList(SingleLinkedList sl) {
            LinkedListNode node = sl.getHead().getNext().getNext();
            sl.getTail().setNext(node);
            return sl;
		}
		
		
		public static LinkedListNode getStartOfLoopFromCircularLinkedList(SingleLinkedList sl){
			LinkedListNode slow = sl.getHead();
			LinkedListNode fast = sl.getHead();
			
			while(fast!=null&& fast.getNext()!=null){
				fast = fast.getNext().getNext();
				slow= slow.getNext();
				if(slow==fast)
					break;
				
			}
			
			if(fast == null || fast.getNext() == null)
				return null;
			
			slow = sl.getHead();
			while(slow!=fast){
				slow = slow.getNext();
				fast = fast.getNext();
			}
			return slow;
		}
		
		
		public static SingleLinkedList removeLoopFromCircularLinkedList(SingleLinkedList sl){
			LinkedListNode slow = sl.getHead();
			LinkedListNode fast = sl.getHead();
			
			while(fast!=null&& fast.getNext()!=null){
				fast = fast.getNext().getNext();
				slow= slow.getNext();
				if(slow==fast)
					break;
				
			}
			
			if(fast == null || fast.getNext() == null)
				return null;
			
			slow = sl.getHead();
			LinkedListNode loop = null;
			while(slow!=fast){
				loop = fast;
				slow = slow.getNext();
				fast = fast.getNext();
			}
			loop.setNext(null);
			return sl;
		}
		
		
		

		public static void iterateLinkedList(SingleLinkedList singleLinkedList){
    		LinkedListNode head = singleLinkedList.getHead();
    		while (head!= null){
    			System.out.print(head.getData()+",");
    			head= head.getNext();
    		}
    		
    	}
		
		
		public static boolean checkPalindromeForSingleLinkedList(SingleLinkedList list){
			StackUsingLinkedList stack = new StackUsingLinkedList();
			LinkedListNode slow = list.getHead();
			LinkedListNode fast = list.getHead();
			while(fast!=null && fast.getNext()!=null){
				stack.push(""+slow.getData());
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}			
			if(fast!= null){
				slow = slow.getNext();
			}			
			while(slow!=null){
				BasicLinkedListNode node = (BasicLinkedListNode)stack.pop();
		      if(slow.getData()!=node.data){
		    	  return false;
		      }
		      slow = slow.getNext();
			}
			return true;
		}
		
		public static SingleLinkedList reverseOfLinkedList(SingleLinkedList list){
			LinkedListNode head = list.getHead() ;
			if(head==null || head.getNext() == null) return list ;
			LinkedListNode current = head.getNext();
			LinkedListNode next = current.getNext() ;
			head.setNext(null);
			while(next != null){
				current.setNext(head);
				head = current ;
				current = next;
				next = next.getNext() ;				
			}
			current.setNext(head);
			list.setHead(current);
			return list ;
		}
		
		public static void printList(LinkedListNode node){
			if(node.getNext()!=null)
				printList(node.getNext());
			System.out.println(node.getData()+",");
		} 
			
		
		
		public static SingleLinkedList reverseOfLinkedListKth(SingleLinkedList list , int k){
			LinkedListNode head = list.getHead();
			if(head == null || head.getNext() == null || k==1)
				return list ;
			LinkedListNode next = null;
			LinkedListNode newhead = null ;
			LinkedListNode tail = null ;
			while(true){
				LinkedListNode current = head ;
				for(int i=0;i<k-1;i++){
					if(current.getNext() == null) break ;
					current = current.getNext();
				}
				next = current.getNext();
				current.setNext(null);
				list.setHead(head);
				reverseOfLinkedList(list);
				if(newhead == null) newhead = current;
				if(tail != null){
					tail.setNext(current);
				}
				tail = head ;
				if(next== null) break;
				head = next ;
			}
			
			list.setHead(newhead);
			return list ;
		}
		
		
	
		
    	
    public void setHead(LinkedListNode head) {
			this.head = head;
		}

	public static SingleLinkedList swapAdjacentNodesInLinkedList(SingleLinkedList list){
    	LinkedListNode node1=list.getHead();
    	LinkedListNode node2 = list.getHead().getNext();
    	
       while(node2!=null&&node2.getNext()!=null){
    	   swapValuesOfNodes(node1, node2);
    	   node2 = node2.getNext().getNext();
    	   node1 = node1.getNext().getNext();
       }
       
       return list;
    }
    
    private static void swapValuesOfNodes(LinkedListNode node1, LinkedListNode node2){
    	int data = node1.getData();
    	node1.setData(node2.getData());
    	node2.setData(data);
    }
    }




