/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public interface Queue {
	
	public int size();
	
	public void enqueue (Object element);
	
	public Object dequeue ();
	
	public boolean isEmpty();
	
	public Object front ();

}
