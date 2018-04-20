/**
 * 
 */
package algorithms;

import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Vibs
 *
 */
public class NCrossNmatrixToPositionII {
	
	public static boolean algorithm(int x,int y, ArrayList<Point> path){
		Point p= new Point(x,y);
		path.add(p);
		if(x==0&& y==0) return true;
		boolean success = false ;
		
		if(x>=1 && isFree(x-1,y))
			success=algoritm(x-1, y, path);
		if(!success && y>=1 && isFree(x,y-1))
			success=algorithm(x,y-1,path);
		if(!success)
			path.remove(p);
		return success ;
	}

}
