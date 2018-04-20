/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class StackUsingLinkedList implements Stack{

	BasicLinkedListNode top ;
	
	private static int size =0;
	
	@Override
	public boolean isEmpty() {
		if(top == null)
		return true;
		else 
		return false;	
	}

	@Override
	public Object pop() {
		if(top != null){
			BasicLinkedListNode node= top;
			top = top.next;
			size -- ;
            return node;
		} 
		return null;
	}

	@Override
	public void push(Object element) {
		BasicLinkedListNode node = new BasicLinkedListNode(Integer.parseInt((String)element));
		node.next = top;
		top = node ;
		size ++ ;
	}

	@Override
	public int size() {		
		return size ;
	}

	
	@Override
	public Object top() {
		return top;
	}
	
    Object peek(){
    	return top.data;
    }

}
