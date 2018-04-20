/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public interface Stack {
	
	public boolean isEmpty();
	
	public Object top();
	
	public void push(Object element);
	
	public Object pop() ;
	
	public int size();

}
