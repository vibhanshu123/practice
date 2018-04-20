/**
 * 
 */
package amazon;

import java.util.LinkedList;
import java.util.Queue;



/**
 * @author Vibs
 *
 */
public class PathBetween2Nodes {
	
	
 public static boolean searchForNodes(Graph g, Node start, Node end){
	LinkedList<Node> queue = new LinkedList<Node>();
	for(Node n:g)
		n.setState(State.Unvisited);
	start.setState(State.Visiting);
	queue.add(start);
	while(!queue.isEmpty()){
		Node u = queue.getFirst();
		for(Node v:u.getGetAdjacentNodes()){
			if(v.getState()!=State.Visited){
				if(v==end) return true;
			}  else{
			    v.setState(State.Visiting);
			     queue.add(v);
			   }
	         }
		u.setState(State.Visited);
	}
	return false ;
 }
	
 




public static boolean searchForNodes(Graph g, Node start, Node end){
	LinkedList<Node> queue = new LinkedList<Node>();
	for(Node u:g.getNodes()){
		u.setState(State.Unvisited);
	}
	start.setState(State.Visiting);
    queue.add(start);
    while(!queue.isEmpty()){
     Node u = queue.removeFirst();
     for(Node v:u.getGetAdjacentNodes()){
    	 if(v.getState()==State.Unvisited){
    		 if(v==end) return true;
    	 }
    	 else{
    		 v.setState(State.Visiting);
    		 queue.addLast(v);
    	 }
     }
     u.setState(State.Visited);
    }
    return false ;
}
}