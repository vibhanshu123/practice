/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class Node {
	
	private State state ;
	
	private Node[] getAdjacentNodes ;

	public Node[] getGetAdjacentNodes() {
		return getAdjacentNodes;
	}

	public void setGetAdjacentNodes(Node[] getAdjacentNodes) {
		this.getAdjacentNodes = getAdjacentNodes;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	

}
