/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class QueueUsingLinkedList implements Queue{

	BasicLinkedListNode front ;
	BasicLinkedListNode rear ;
	private static int size=0;
	
	@Override
	public Object dequeue() {
		if(front != null){
			BasicLinkedListNode returnFront = front;
			front = front.next;
			size -- ;
			return returnFront;
		}
		return null;
	}

	@Override
	public void enqueue(Object element) {
		BasicLinkedListNode node = new BasicLinkedListNode(Integer.parseInt((String)element));
		BasicLinkedListNode head = front ;
		if( front == null){
			front = node ;
		    rear = front;
		}else {
			rear.next = node ;
			rear = rear.next;
		}
		size ++ ;
	}


	@Override
	public Object front() {
		return front;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(front == null) return true ;
		 return false ;
	}


	@Override
	public int size() {
		return size;
	}

}
