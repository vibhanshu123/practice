/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class BoundaryVioLationException extends RuntimeException {
  
	public String message(){
		return ("Boundary Violated");
	}
	
	/**
	 * 
	 */
	public BoundaryVioLationException(String message) {
		super(message);
	}
	
}
